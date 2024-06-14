package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.entities.concretes.File;
import com.tobeto.java4a.hotelnow.services.dtos.responses.files.FileDetailResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface FileService {

    CompletableFuture<List<FileDetailResponse>> uploadFilesAsync(String path, List<MultipartFile> files);
    File save(File file);

}
