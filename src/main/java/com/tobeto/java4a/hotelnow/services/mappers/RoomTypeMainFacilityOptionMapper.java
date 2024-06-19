package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeMainFacilityOption;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityoptions.AddRoomTypeMainFacilityOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityoptions.UpdateRoomTypeMainFacilityOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityoptions.AddRoomTypeMainFacilityOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityoptions.ListRoomTypeMainFacilityOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityoptions.UpdateRoomTypeMainFacilityOptionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomTypeMainFacilityOptionMapper {

    RoomTypeMainFacilityOptionMapper INSTANCE = Mappers.getMapper(RoomTypeMainFacilityOptionMapper.class);
    @Mapping(target = "roomTypeMainFacilitySelectionResponse" , source = "roomTypeMainFacilitySelections")
    ListRoomTypeMainFacilityOptionResponse listResponseFromRoomTypeMainFacilityOption(RoomTypeMainFacilityOption roomTypeMainFacilityOption);

    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "roomTypeMainFacilitySelections" , ignore = true)
    RoomTypeMainFacilityOption roomTypeMainFacilityOptionFromAddRequest(AddRoomTypeMainFacilityOptionRequest request);

    AddRoomTypeMainFacilityOptionResponse addResponseFromTypeFacilityOption(RoomTypeMainFacilityOption roomTypeMainFacilityOption);
    @Mapping(target = "roomTypeMainFacilitySelections" , ignore = true)
    RoomTypeMainFacilityOption roomTypeMainFacilityOptionFromUpdateRequest(UpdateRoomTypeMainFacilityOptionRequest request);

    UpdateRoomTypeMainFacilityOptionResponse updateResponseFromRoomTypeMainFacilityOption(RoomTypeMainFacilityOption roomTypeMainFacilityOption);











}
