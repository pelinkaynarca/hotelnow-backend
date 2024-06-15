package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.Image;
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
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoomTypeImageServiceImpl implements RoomTypeImageService {

    private final RoomTypeImageRepository imageRepository;
    private final ImageService imageService;

    @Override
    public ListRoomTypeImageResponse getByRoomTypeId(int roomTypeId) {
        List<RoomTypeImage> roomTypeImages = imageRepository.findByRoomTypeId(roomTypeId);

        List<Image> images = roomTypeImages.stream()
                .map(RoomTypeImage::getImage)
                .collect(Collectors.toList());
        return RoomTypeImageMapper.INSTANCE.listResponseFromRoomTypeImage(
                roomTypeImages.isEmpty() ? null : roomTypeImages.get(0),
                images
        );
    }

    @Override
    public ListRoomTypeImageResponse getById(int id) {
        RoomTypeImage image = imageRepository.findById(id).orElse(null);
        return RoomTypeImageMapper.INSTANCE.listResponseFromRoomTypeImage(image, image != null ? List.of(image.getImage()) : List.of());
    }

    @Override
    public AddRoomTypeImageResponse add(AddRoomTypeImageRequest request) {
        RoomTypeImage roomTypeImage = RoomTypeImageMapper.INSTANCE.roomTypeImageFromAddRequest(request);

        RoomTypeImage savedRoomTypeImage = imageRepository.save(roomTypeImage);

        List<MultipartFile> files = request.getFiles();
        List<ImageDetailResponse> imageDetails = imageService.uploadImagesAsync("room-types", files).join();

        List<Image> uploadedImages = RoomTypeImageMapper.INSTANCE.mapImageDetailsToImages(imageDetails);
        uploadedImages.forEach(imageService::save);

        if (!uploadedImages.isEmpty()) {
            Image mainImage = uploadedImages.get(0);
            savedRoomTypeImage.setImage(mainImage);
            imageRepository.save(savedRoomTypeImage);
        }

        return RoomTypeImageMapper.INSTANCE.addResponseFromRoomTypeImage(savedRoomTypeImage, uploadedImages);
    }

    @Override
    public void delete(int imageId) {
        imageService.delete(imageId);
    }

    @Override
    public List<ListImageResponse> getResponse(List<RoomTypeImage> roomTypeImages) {
        return roomTypeImages.stream()
                .map(image -> RoomTypeImageMapper.INSTANCE.listResponseFromImage(image.getImage()))
                .collect(Collectors.toList());
    }
}
