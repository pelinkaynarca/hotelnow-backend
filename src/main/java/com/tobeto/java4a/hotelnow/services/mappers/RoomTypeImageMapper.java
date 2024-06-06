package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeImage;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypeimages.AddRoomTypeImageRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypeimages.AddRoomTypeImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypeimages.ListRoomTypeImageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomTypeImageMapper {

    RoomTypeImageMapper INSTANCE = Mappers.getMapper(RoomTypeImageMapper.class);

    @Mapping(target = "roomTypeId", source = "roomType.id")
    ListRoomTypeImageResponse listResponseFromRoomTypeImage(RoomTypeImage roomTypeImage);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roomType.id" , source = "roomTypeId")
    RoomTypeImage roomTypeImageFromAddRequest(AddRoomTypeImageRequest request);

    @Mapping(target = "roomTypeId", source = "roomType.id")
    AddRoomTypeImageResponse addResponseFromRoomTypeImage(RoomTypeImage roomTypeImage);

}
