package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeFacilityDetailSelection;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailselections.AddRoomTypeFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailselections.UpdateRoomTypeFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.AddRoomTypeFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.ListRoomTypeFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.UpdateRoomTypeFacilityDetailSelectionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomTypeFacilityDetailSelectionMapper {

    RoomTypeFacilityDetailSelectionMapper INSTANCE = Mappers.getMapper(RoomTypeFacilityDetailSelectionMapper.class);

    @Mapping(target = "roomTypeName", source = "roomType.name")
    @Mapping(target = "optionDescription", source = "roomTypeFacilityDetailOption.description")
    ListRoomTypeFacilityDetailSelectionResponse listResponseFromRoomTypeFacilityDetailSelection(RoomTypeFacilityDetailSelection RoomTypeFacilityDetailSelection);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roomType.id", source = "roomTypeId")
    @Mapping(target = "roomTypeFacilityDetailOption.id", source = "optionId")
    RoomTypeFacilityDetailSelection roomTypeFacilityDetailSelectionFromAddRequest(AddRoomTypeFacilityDetailSelectionRequest request);

    @Mapping(target = "roomTypeId", source = "roomType.id")
    @Mapping(target = "optionId", source = "roomTypeFacilityDetailOption.id")
    AddRoomTypeFacilityDetailSelectionResponse addResponseFromRoomTypeFacilityDetailSelection(RoomTypeFacilityDetailSelection roomTypeFacilityDetailSelection);

    @Mapping(target = "roomType.id", source = "roomTypeId")
    @Mapping(target = "roomTypeFacilityDetailOption.id", source = "optionId")
    RoomTypeFacilityDetailSelection roomTypeFacilityDetailSelectionFromUpdateRequest(UpdateRoomTypeFacilityDetailSelectionRequest request);

    @Mapping(target = "roomTypeId", source = "roomType.id")
    @Mapping(target = "optionId", source = "roomTypeFacilityDetailOption.id")
    UpdateRoomTypeFacilityDetailSelectionResponse updateResponseFromRoomTypeFacilityDetailSelection(RoomTypeFacilityDetailSelection roomTypeFacilityDetailSelection);
}
