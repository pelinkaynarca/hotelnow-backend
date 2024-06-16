package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.responses.images.ImageDetailResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ImageService {
    CompletableFuture<List<ImageDetailResponse>> uploadImagesAsync(String path, List<MultipartFile> files);
    void delete(int id);
}
