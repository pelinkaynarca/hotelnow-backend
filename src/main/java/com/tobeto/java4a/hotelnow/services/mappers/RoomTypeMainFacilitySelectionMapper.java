package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeMainFacilitySelection;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityselections.AddRoomTypeMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityselections.UpdateRoomTypeMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.AddRoomTypeMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.ListRoomTypeMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.UpdateRoomTypeMainFacilitySelectionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomTypeMainFacilitySelectionMapper {

    RoomTypeMainFacilitySelectionMapper INSTANCE = Mappers.getMapper(RoomTypeMainFacilitySelectionMapper.class);

    @Mapping(target = "roomTypeName", source = "roomType.name")
    @Mapping(target = "optionTitle", source = "roomTypeMainFacilityOption.title")
    ListRoomTypeMainFacilitySelectionResponse listResponseFromRoomTypeMainFacilitySelection(RoomTypeMainFacilitySelection roomTypeMainFacilitySelection);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roomType.id", source = "roomTypeId")
    @Mapping(target = "roomTypeMainFacilityOption.id", source = "optionId")
    RoomTypeMainFacilitySelection roomTypeMainFacilitySelectionFromAddRequest(AddRoomTypeMainFacilitySelectionRequest request);

    @Mapping(target = "roomTypeId", source = "roomType.id")
    @Mapping(target = "optionId", source = "roomTypeMainFacilityOption.id")
    AddRoomTypeMainFacilitySelectionResponse addResponseFromRoomTypeMainFacilitySelection(RoomTypeMainFacilitySelection roomTypeMainFacilitySelection);

    @Mapping(target = "roomType.id", source = "roomTypeId")
    @Mapping(target = "roomTypeMainFacilityOption.id", source = "optionId")
    RoomTypeMainFacilitySelection roomTypeMainFacilitySelectionFromUpdateRequest(UpdateRoomTypeMainFacilitySelectionRequest request);

    @Mapping(target = "roomTypeId", source = "roomType.id")
    @Mapping(target = "optionId", source = "roomTypeMainFacilityOption.id")
    UpdateRoomTypeMainFacilitySelectionResponse updateResponseFromRoomTypeMainFacilitySelection(RoomTypeMainFacilitySelection roomTypeMainFacilitySelection);
}
