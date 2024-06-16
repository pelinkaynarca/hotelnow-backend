package com.tobeto.java4a.hotelnow.services.mappers;

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

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface RoomTypeImageMapper {

    RoomTypeImageMapper INSTANCE = Mappers.getMapper(RoomTypeImageMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "imageName", source = "imageName")
    @Mapping(target = "path", source = "path")
    ListImageResponse listResponseFromImage(RoomTypeImage roomTypeImage);

    @Mappings({
            @Mapping(target = "roomTypeId", source = "roomTypeImage.roomType.id"),
            @Mapping(target = "photos", source = "imageResponses")
    })
    ListRoomTypeImageResponse listResponseByRoomTypeId(RoomTypeImage roomTypeImage, List<ListImageResponse> imageResponses);

    @Mappings({
            @Mapping(target = "imageName", source = "imageName"),
            @Mapping(target = "path", source = "pathOrContainerName"),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "roomType", ignore = true)
    })
    RoomTypeImage listResponseFromImageDetail(ImageDetailResponse imageDetail);

    @Mapping(target = "roomType.id", source = "roomTypeId")
    RoomTypeImage roomTypeImageFromAddRequest(AddRoomTypeImageRequest request);

    @Mapping(target = "roomTypeId", source = "request.roomTypeId")
    @Mapping(target = "photos", source = "savedImages")
    AddRoomTypeImageResponse addResponseFromRoomTypeImage(AddRoomTypeImageRequest request, List<RoomTypeImage> savedImages);

    List<ListImageResponse> listResponseFromImageResponses(List<RoomTypeImage> roomTypeImages);

    default List<RoomTypeImage> listRoomTypeImages(List<ImageDetailResponse> imageDetails, RoomTypeImage existingImage) {
        List<RoomTypeImage> list = new ArrayList<>();
        for (ImageDetailResponse detail : imageDetails) {
            RoomTypeImage newImage = listResponseFromImageDetail(detail);
            newImage.setRoomType(existingImage.getRoomType());
            list.add(newImage);
        }
        return list;
    }
}
