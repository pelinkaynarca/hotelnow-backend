package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeImage;
import com.tobeto.java4a.hotelnow.repositories.RoomTypeImageRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.ImageService;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeImageService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypeimages.AddRoomTypeImageRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.images.ImageDetailResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.images.ListImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypeimages.AddRoomTypeImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypeimages.ListRoomTypeImageResponse;
import com.tobeto.java4a.hotelnow.services.mappers.RoomTypeImageMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class RoomTypeImageServiceImpl implements RoomTypeImageService {

    private final RoomTypeImageRepository imageRepository;
    private final ImageService imageService;

    @Override
    public ListRoomTypeImageResponse getByRoomTypeId(int roomTypeId) {
        List<RoomTypeImage> roomTypeImages = imageRepository.findByRoomTypeId(roomTypeId);
        List<ListImageResponse> imageResponses = RoomTypeImageMapper.INSTANCE.listResponseFromImageResponses(roomTypeImages);

        return RoomTypeImageMapper.INSTANCE.listResponseByRoomTypeId(
                roomTypeImages.isEmpty() ? null : roomTypeImages.get(0), imageResponses);
    }

    @Override
    public AddRoomTypeImageResponse add(AddRoomTypeImageRequest request) {
        RoomTypeImage initialImage = RoomTypeImageMapper.INSTANCE.roomTypeImageFromAddRequest(request);

        List<MultipartFile> files = request.getFiles();
        CompletableFuture<List<ImageDetailResponse>> uploadResult = imageService.uploadImagesAsync("room-types", files);

        List<ImageDetailResponse> imageDetails = uploadResult.join();

        List<RoomTypeImage> roomTypeImages = RoomTypeImageMapper.INSTANCE.listRoomTypeImages(imageDetails, initialImage);

        List<RoomTypeImage> savedImages = imageRepository.saveAll(roomTypeImages);

        return RoomTypeImageMapper.INSTANCE.addResponseFromRoomTypeImage(request, savedImages);
    }

    @Override
    public void delete(int imageId) {
        imageService.delete(imageId);
    }

    @Override
    public List<ListImageResponse> getResponse(List<RoomTypeImage> roomTypeImages) {
        return RoomTypeImageMapper.INSTANCE.listResponseFromImageResponses(roomTypeImages);
    }
}

