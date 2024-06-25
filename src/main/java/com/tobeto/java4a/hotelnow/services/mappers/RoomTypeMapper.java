package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.Hotel;
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

    @Mapping(target = "bedTypeName", source = "roomBedType.name")
    @Mapping(target = "viewTypeName", source = "roomViewType.name")
    ListRoomTypeResponse listResponse(RoomType roomType);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roomTypeImages", ignore = true)
    @Mapping(target = "rooms", ignore = true)
    @Mapping(target = "bookedRoomTypes", ignore = true)
    @Mapping(target = "roomTypeFacilityDetailSelections", ignore = true)
    @Mapping(target = "name", source = "request.name")
    @Mapping(target = "capacity", source = "request.capacity")
    @Mapping(target = "description", source = "request.description")
    @Mapping(target = "pricePerNight", source = "request.pricePerNight")
    @Mapping(target = "display", source = "request.display")
    @Mapping(target = "size", source = "request.size")
    @Mapping(target = "currency", source = "request.currency")
    @Mapping(target = "roomBedType.id", source = "request.bedTypeId")
    @Mapping(target = "roomViewType.id", source = "request.viewTypeId")
    @Mapping(target = "hotel", source = "hotel")
    RoomType roomTypeFromAddRequest(AddRoomTypeRequest request, Hotel hotel);

    @Mapping(target = "bedTypeId", source = "roomBedType.id")
    @Mapping(target = "viewTypeId", source = "roomViewType.id")
    AddRoomTypeResponse addResponseFromRoomType(RoomType roomType);

    @Mapping(target = "id", source = "request.id")
    @Mapping(target = "roomTypeImages", ignore = true)
    @Mapping(target = "rooms", ignore = true)
    @Mapping(target = "bookedRoomTypes", ignore = true)
    @Mapping(target = "roomTypeFacilityDetailSelections", ignore = true)
    @Mapping(target = "name", source = "request.name")
    @Mapping(target = "capacity", source = "request.capacity")
    @Mapping(target = "description", source = "request.description")
    @Mapping(target = "pricePerNight", source = "request.pricePerNight")
    @Mapping(target = "display", source = "request.display")
    @Mapping(target = "size", source = "request.size")
    @Mapping(target = "currency", source = "request.currency")
    @Mapping(target = "roomBedType.id", source = "request.bedTypeId")
    @Mapping(target = "roomViewType.id", source = "request.viewTypeId")
    @Mapping(target = "hotel", source = "hotel")
    RoomType roomTypeFromUpdateRequest(UpdateRoomTypeRequest request, Hotel hotel);

    @Mapping(target = "bedTypeId", source = "roomBedType.id")
    @Mapping(target = "viewTypeId", source = "roomViewType.id")
    UpdateRoomTypeResponse updateResponseFromRoomType(RoomType room);
}
