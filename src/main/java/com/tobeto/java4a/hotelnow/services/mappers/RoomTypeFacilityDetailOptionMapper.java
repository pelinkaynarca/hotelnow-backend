package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeFacilityDetailOption;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailoptions.AddRoomTypeFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailoptions.UpdateRoomTypeFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailoptions.AddRoomTypeFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailoptions.ListRoomTypeFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailoptions.UpdateRoomTypeFacilityDetailOptionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface RoomTypeFacilityDetailOptionMapper {

    @Mapping(target = "categoryTitle", source = "roomTypeFacilityCategory.title")
    ListRoomTypeFacilityDetailOptionResponse listResponseFromFacilityDetailOption(RoomTypeFacilityDetailOption roomTypeFacilityDetailOption);

    @Mapping(target = "roomTypeFacilityCategory.id", source = "categoryId")
    RoomTypeFacilityDetailOption roomTypeFacilityDetailOptionFromAddRequest(AddRoomTypeFacilityDetailOptionRequest request);

    @Mapping(target = "categoryTitle", source = "roomTypeFacilityCategory.title")
    AddRoomTypeFacilityDetailOptionResponse addResponseFromRoomTypeFacilityDetailOption(RoomTypeFacilityDetailOption roomTypeFacilityDetailOption);

    @Mapping(target = "roomTypeFacilityCategory.id", source = "categoryId")
    RoomTypeFacilityDetailOption roomTypeFacilityDetailOptionFromUpdateRequest(UpdateRoomTypeFacilityDetailOptionRequest request);

    @Mapping(target = "categoryTitle", source = "roomTypeFacilityCategory.title")
    UpdateRoomTypeFacilityDetailOptionResponse updateResponseFromRoomTypeFacilityDetailOption(RoomTypeFacilityDetailOption roomTypeFacilityDetailOption);

}
