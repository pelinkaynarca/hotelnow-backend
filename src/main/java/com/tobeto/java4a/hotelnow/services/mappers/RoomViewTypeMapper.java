package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomViewType;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomviewtypes.AddRoomViewTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomviewtypes.UpdateRoomViewTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomviewtypes.AddRoomViewTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomviewtypes.ListRoomViewTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomviewtypes.UpdateRoomViewTypeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomViewTypeMapper {

    RoomViewTypeMapper INSTANCE = Mappers.getMapper(RoomViewTypeMapper.class);

    ListRoomViewTypeResponse listResponseFromRoomViewType(RoomViewType viewType);

    @Mapping(target = "id", ignore = true)
    RoomViewType roomViewTypeFromAddRequest (AddRoomViewTypeRequest request );

    AddRoomViewTypeResponse addResponseFromRoomViewType(RoomViewType viewType);

    RoomViewType roomViewTypeFromUpdateRequest(UpdateRoomViewTypeRequest request);

    UpdateRoomViewTypeResponse updateResponseFromRoomViewType(RoomViewType viewType);
}
