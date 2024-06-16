package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.Image;
import com.tobeto.java4a.hotelnow.repositories.ImageRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.ImageService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.images.ImageDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Value("${spring.image.dir}")
    private String baseUploadDir;

    @Override
    public CompletableFuture<List<ImageDetailResponse>> uploadImagesAsync(String directoryPath, List<MultipartFile> files) {
        Path uploadLocation = Paths.get(baseUploadDir, directoryPath);

        try {
            createDirectoriesIfNotExist(uploadLocation);

            List<CompletableFuture<ImageDetailResponse>> uploadTasks = files.stream()
                    .map(file -> uploadFile(uploadLocation, file, directoryPath))
                    .toList();

            CompletableFuture<Void> allFutures = CompletableFuture.allOf(uploadTasks.toArray(new CompletableFuture[0]));

            return allFutures.thenApply(v ->
                    uploadTasks.stream()
                            .map(CompletableFuture::join)
                            .collect(Collectors.toList())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createDirectoriesIfNotExist(Path uploadLocation) throws IOException {
        if (!Files.exists(uploadLocation)) {
            Files.createDirectories(uploadLocation);
        }
    }

    private CompletableFuture<ImageDetailResponse> uploadFile(Path uploadLocation, MultipartFile file, String directoryPath) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                String originalFileName = file.getOriginalFilename();
                String uniqueFileName = generateUniqueFileName(uploadLocation, originalFileName);
                Path targetLocation = uploadLocation.resolve(uniqueFileName);
                Files.copy(file.getInputStream(), targetLocation);

                return createImageDetailResponse(directoryPath, uniqueFileName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private String generateUniqueFileName(Path uploadLocation, String originalFileName) throws IOException {
        String fileBaseName = Paths.get(originalFileName).getFileName().toString().replaceFirst("[.][^.]+$", "").replaceAll("\\s", "_");
        String fileExtension = "." + originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        String uniqueFileName;
        int counter = 1;

        do {
            uniqueFileName = String.format("%s-%d%s", fileBaseName, counter++, fileExtension);
        } while (Files.exists(uploadLocation.resolve(uniqueFileName)));

        return uniqueFileName;
    }

    private ImageDetailResponse createImageDetailResponse(String relativePath, String fileName) {
        ImageDetailResponse response = new ImageDetailResponse();
        response.setImageName(fileName);
        response.setPathOrContainerName(relativePath.replace("\\", "/") + "/" + fileName);
        return response;
    }

    @Override
    @Transactional
    public void delete(int id) {
        Image image = imageRepository.findById(id).orElse(null);

        Path imagePath = Paths.get(baseUploadDir, image != null ? image.getPath().replace("/", "\\") : null);
        deleteFileSilently(imagePath);
        imageRepository.deleteById(id);
    }

    private void deleteFileSilently(Path path) {
        try {
            if (Files.exists(path)) {
                Files.delete(path);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
