package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.File;
import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeImage;
import com.tobeto.java4a.hotelnow.repositories.RoomTypeImageRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.FileService;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeImageService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypeimages.AddRoomTypeImageRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.files.FileDetailResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.files.ListFileResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypeimages.AddRoomTypeImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypeimages.ListRoomTypeImageResponse;
import com.tobeto.java4a.hotelnow.services.mappers.RoomTypeImageMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoomTypeImageServiceImpl implements RoomTypeImageService {

    private final RoomTypeImageRepository imageRepository;
    private final FileService fileService;

    @Override
    public ListRoomTypeImageResponse getByRoomTypeId(int roomTypeId) {
        List<RoomTypeImage> roomTypeImages = imageRepository.findByRoomTypeId(roomTypeId);

        List<File> allFiles = roomTypeImages.stream()
                .map(RoomTypeImage::getFile)
                .collect(Collectors.toList());
        return RoomTypeImageMapper.INSTANCE.listResponseFromRoomTypeImage(
                roomTypeImages.isEmpty() ? null : roomTypeImages.get(0),
                allFiles
        );
    }

    @Override
    public ListRoomTypeImageResponse getById(int id) {
        RoomTypeImage image = imageRepository.findById(id).orElse(null);
        return RoomTypeImageMapper.INSTANCE.listResponseFromRoomTypeImage(image, image != null ? List.of(image.getFile()) : List.of());
    }

    @Override
    public AddRoomTypeImageResponse add(AddRoomTypeImageRequest request) {
        RoomTypeImage roomTypeImage = RoomTypeImageMapper.INSTANCE.roomTypeImageFromAddRequest(request);

        List<MultipartFile> files = request.getFiles();

        List<FileDetailResponse> fileDetailResponses = fileService.uploadFilesAsync("room-type", files).join();

        List<File> uploadedFiles = RoomTypeImageMapper.INSTANCE.mapFileDetailsToFiles(fileDetailResponses);
        uploadedFiles.forEach(fileService::save);

        if (!uploadedFiles.isEmpty()) {
            File mainFile = uploadedFiles.get(0);
            roomTypeImage.setFile(mainFile);
        }

        imageRepository.save(roomTypeImage);

        return RoomTypeImageMapper.INSTANCE.addResponseFromRoomTypeImage(roomTypeImage, uploadedFiles);
    }

    @Override
    public void delete(int id) {
        imageRepository.deleteById(id);
    }

    @Override
    public List<ListFileResponse> getResponse(List<RoomTypeImage> roomTypeImages) {
        return roomTypeImages.stream()
                .map(image -> RoomTypeImageMapper.INSTANCE.listResponseFromFile(image.getFile()))
                .collect(Collectors.toList());
    }
}
