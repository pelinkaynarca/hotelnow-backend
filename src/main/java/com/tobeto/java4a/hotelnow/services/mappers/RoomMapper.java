package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.Room;
import com.tobeto.java4a.hotelnow.services.dtos.requests.rooms.AddRoomRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.rooms.UpdateRoomRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.rooms.AddRoomResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.rooms.ListRoomResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.rooms.UpdateRoomResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    @Mapping(target = "roomTypeName", source = "roomType.name")
    ListRoomResponse listResponseFromRoom(Room room);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roomType.id", source = "roomTypeId")
    Room roomFromAddRequest(AddRoomRequest request);

    @Mapping(target = "roomTypeId", source = "roomType.id")
    AddRoomResponse addResponseFromRoom(Room room);

    @Mapping(target = "roomType.id", source = "roomTypeId")
    Room roomFromUpdateRequest(UpdateRoomRequest request);

    @Mapping(target = "roomTypeId", source = "roomType.id")
    UpdateRoomResponse updateResponseFromRoom(Room room);
}
