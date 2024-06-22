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
    @Mapping(target = "categoryTitle", source = "roomTypeMainFacilityCategory.title")
    ListRoomTypeMainFacilityOptionResponse listResponseFromRoomTypeMainFacilityOption(RoomTypeMainFacilityOption roomTypeMainFacilityOption);

    @Mapping(target = "roomTypeMainFacilityCategory.id", source = "categoryId")
    RoomTypeMainFacilityOption roomTypeMainFacilityOptionFromAddRequest(AddRoomTypeMainFacilityOptionRequest request);
    @Mapping(target = "categoryId", source = "roomTypeMainFacilityCategory.id")
    AddRoomTypeMainFacilityOptionResponse addResponseFromTypeFacilityOption(RoomTypeMainFacilityOption roomTypeMainFacilityOption);
    @Mapping(target = "roomTypeMainFacilityCategory.id", source = "categoryId")
    RoomTypeMainFacilityOption roomTypeMainFacilityOptionFromUpdateRequest(UpdateRoomTypeMainFacilityOptionRequest request);
    @Mapping(target = "categoryId", source = "roomTypeMainFacilityCategory.id")
    UpdateRoomTypeMainFacilityOptionResponse updateResponseFromRoomTypeMainFacilityOption(RoomTypeMainFacilityOption roomTypeMainFacilityOption);

}
