package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.Image;
import com.tobeto.java4a.hotelnow.repositories.ImageRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.ImageService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.images.ImageDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    @Value("${spring.image.dir}")
    private String baseUploadDir;

    private final ImageRepository imageRepository;

    @Override
    public CompletableFuture<List<ImageDetailResponse>> uploadImagesAsync(String directoryPath, List<MultipartFile> files) {
        return CompletableFuture.supplyAsync(() -> {
            List<ImageDetailResponse> imageDetails = new ArrayList<>();
            Path fullUploadPath = Paths.get(baseUploadDir, directoryPath);

            createDirectoryIfNotExists(fullUploadPath);

            files.forEach(file -> {
                try {
                    String originalFileName = file.getOriginalFilename();
                    String uniqueFileName = generateUniqueFileName(fullUploadPath, originalFileName);
                    Path filePath = fullUploadPath.resolve(uniqueFileName);
                    Files.copy(file.getInputStream(), filePath);
                    imageDetails.add(createImageDetailResponse(directoryPath, uniqueFileName));
                } catch (IOException e) {
                    throw new RuntimeException("Failed to store image: " + file.getOriginalFilename(), e);
                }
            });

            return imageDetails;
        });
    }

    private void createDirectoryIfNotExists(Path path) {
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            throw new RuntimeException("Failed to create directory: " + path, e);
        }
    }

    private String generateUniqueFileName(Path directoryPath, String originalFileName) {
        String fileBaseName = Paths.get(originalFileName).getFileName().toString().replaceFirst("[.][^.]+$", "").replaceAll("\\s", "_");
        String fileExtension = "." + originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        String uniqueFileName;
        int counter = 1;

        do {
            uniqueFileName = String.format("%s-%d%s", fileBaseName, counter++, fileExtension);
        } while (Files.exists(directoryPath.resolve(uniqueFileName)));

        return uniqueFileName;
    }

    private ImageDetailResponse createImageDetailResponse(String directoryPath, String fileName) {
        ImageDetailResponse response = new ImageDetailResponse();
        response.setImageName(fileName);
        response.setPathOrContainerName(directoryPath.replace("\\", "/") + "/" + fileName);
        return response;
    }

    @Override
    public Image save(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public void delete(int id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RoomTypeImage not found for id: " + id));

        Path imagePath = Paths.get(baseUploadDir, image.getPath().replace("/", "\\"));
        deleteFileSilently(imagePath);
        imageRepository.deleteById(id);
    }

    private void deleteFileSilently(Path path) {
        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException ignored) {
            }
        }
    }
}
