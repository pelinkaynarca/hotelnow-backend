package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.File;
import com.tobeto.java4a.hotelnow.repositories.FileRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.FileService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.files.FileDetailResponse;
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
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    @Value("${spring.file.dir}")
    private String uploadDir;

    private final FileRepository fileRepository;
    private final AtomicInteger counter = new AtomicInteger(0);

    @Override
    public CompletableFuture<List<FileDetailResponse>> uploadFilesAsync(String path, List<MultipartFile> files) {
        return CompletableFuture.supplyAsync(() -> {
            List<FileDetailResponse> fileDetailResponses = new ArrayList<>();

            Path uploadPath = Paths.get(uploadDir + "/" + path);
            try {
                Files.createDirectories(uploadPath);
            } catch (IOException e) {
                throw new RuntimeException("Failed to create directory", e);
            }

            for (MultipartFile file : files) {
                String originalFileName = file.getOriginalFilename();
                String newFileName = generateUniqueFileName(uploadPath,originalFileName);
                Path filePath = uploadPath.resolve(newFileName);

                if (Files.exists(filePath)) {
                    newFileName = generateUniqueFileName(uploadPath, originalFileName);
                    filePath = uploadPath.resolve(newFileName);
                }

                try {
                    Files.copy(file.getInputStream(), filePath);
                } catch (IOException e) {
                    throw new RuntimeException("Failed to store file " + originalFileName, e);
                }

                FileDetailResponse fileDetailResponse = new FileDetailResponse();
                fileDetailResponse.setFileName(newFileName);
                fileDetailResponse.setPathOrContainerName(path + "/" + newFileName);
                fileDetailResponses.add(fileDetailResponse);
            }

            return fileDetailResponses;
        });
    }

    private String generateUniqueFileName(Path uploadPath, String originalFileName) {
        String fileNameWithoutExtension = Paths.get(originalFileName).getFileName().toString().replaceFirst("[.][^.]+$", "");
        fileNameWithoutExtension = fileNameWithoutExtension.replaceAll("\\s", "_");
        String extension = "." + originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        int count = 1;
        String newFileName;

        do {
            newFileName = fileNameWithoutExtension + "-" + count++ + extension;
        } while (Files.exists(uploadPath.resolve(newFileName)));

        return newFileName;
    }

    @Override
    public File save(File file) {
        return fileRepository.save(file);
    }
}
