package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.Image;
import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeImage;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypeimages.AddRoomTypeImageRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.images.ImageDetailResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.images.ListImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypeimages.AddRoomTypeImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypeimages.ListRoomTypeImageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface RoomTypeImageMapper {

    RoomTypeImageMapper INSTANCE = Mappers.getMapper(RoomTypeImageMapper.class);

    @Mappings({
            @Mapping(target = "roomTypeId", source = "roomTypeImage.roomType.id"),
            @Mapping(target = "photos", expression = "java(mapImageToPhotos(images))")
    })
    ListRoomTypeImageResponse listResponseFromRoomTypeImage(RoomTypeImage roomTypeImage, List<Image> images);


    @Mapping(target = "imageName", source = "image.imageName")
    ListImageResponse listResponseFromImage(Image image);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "roomType.id", source = "roomTypeId"),
            @Mapping(target = "image", ignore = true)
    })
    RoomTypeImage roomTypeImageFromAddRequest(AddRoomTypeImageRequest request);

    @Mappings({
            @Mapping(target = "roomTypeId", source = "roomTypeImage.roomType.id"),
            @Mapping(target = "photos", expression = "java(mapImageToPhotos(images))")
    })
    AddRoomTypeImageResponse addResponseFromRoomTypeImage(RoomTypeImage roomTypeImage, List<Image> images);

    default List<ListImageResponse> mapImageToPhotos(List<Image> images) {
        return images.stream()
                .map(this::listResponseFromImage)
                .collect(Collectors.toList());
    }

    default List<Image> mapImageDetailsToImages(List<ImageDetailResponse> imageDetails) {
        return imageDetails.stream()
                .map(imageDetailResponse -> {
                    Image image = new Image();
                    image.setImageName(imageDetailResponse.getImageName());
                    image.setPath(imageDetailResponse.getPathOrContainerName());
                    return image;
                })
                .collect(Collectors.toList());
    }
}
