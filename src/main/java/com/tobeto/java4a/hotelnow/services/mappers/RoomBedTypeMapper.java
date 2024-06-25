package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomBedType;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roombedtypes.AddRoomBedTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roombedtypes.UpdateRoomBedTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roombedtypes.AddRoomBedTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roombedtypes.ListRoomBedTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roombedtypes.UpdateRoomBedTypeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomBedTypeMapper {

    RoomBedTypeMapper INSTANCE = Mappers.getMapper(RoomBedTypeMapper.class);

    ListRoomBedTypeResponse listResponseFromRoomBedType(RoomBedType badType);

    @Mapping(target = "id", ignore = true)
    RoomBedType roomBedTypeFromAddRequest (AddRoomBedTypeRequest request );

    AddRoomBedTypeResponse addResponseFromRoomBedType(RoomBedType badType);

    RoomBedType roomBedTypeFromUpdateRequest(UpdateRoomBedTypeRequest request);

    UpdateRoomBedTypeResponse updateResponseFromRoomBedType(RoomBedType badType);
}
