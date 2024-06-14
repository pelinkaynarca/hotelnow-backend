package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomType;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypes.AddRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypes.UpdateRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.AddRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.ListRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.UpdateRoomTypeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomTypeMapper {

    RoomTypeMapper INSTANCE = Mappers.getMapper(RoomTypeMapper.class);

    @Mapping(target = "rooms", source = "rooms")
    @Mapping(target = "roomTypeFacilityDetailSelections", source = "roomTypeFacilityDetailSelections")
    @Mapping(target = "roomTypeMainFacilitySelections", source = "roomTypeMainFacilitySelections")
    ListRoomTypeResponse listResponseFromRoomType(RoomType roomType);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "hotel", ignore = true)
    @Mapping(target = "roomTypeImages", ignore = true)
    @Mapping(target = "rooms", ignore = true)
    @Mapping(target = "bookedRoomTypes", ignore = true)
    RoomType roomTypeFromAddRequest(AddRoomTypeRequest request);

    AddRoomTypeResponse addResponseFromRoomType(RoomType roomType);

    @Mapping(target = "hotel", ignore = true)
    @Mapping(target = "roomTypeImages", ignore = true)
    @Mapping(target = "rooms", ignore = true)
    @Mapping(target = "bookedRoomTypes", ignore = true)
    RoomType roomTypeFromUpdateRequest(UpdateRoomTypeRequest request);

    UpdateRoomTypeResponse updateResponseFromRoomType(RoomType room);
}
