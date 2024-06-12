package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeFacilityDetailOption;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailoptions.AddRoomTypeFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailoptions.UpdateRoomTypeFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailoptions.AddRoomTypeFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailoptions.ListRoomTypeFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailoptions.UpdateRoomTypeFacilityDetailOptionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomTypeFacilityDetailOptionMapper {

    RoomTypeFacilityDetailOptionMapper INSTANCE = Mappers.getMapper(RoomTypeFacilityDetailOptionMapper.class);

    @Mapping(target = "categoryTitle", source = "roomTypeFacilityCategory.title")
    ListRoomTypeFacilityDetailOptionResponse listResponseFromRoomTypeFacilityDetailOption(RoomTypeFacilityDetailOption roomTypeFacilityDetailOption);

    @Mapping(target = "roomTypeFacilityCategory.id", source = "categoryId")
    RoomTypeFacilityDetailOption roomTypeFacilityDetailOptionFromAddRequest(AddRoomTypeFacilityDetailOptionRequest request);

    @Mapping(target = "categoryId", source = "roomTypeFacilityCategory.id")
    AddRoomTypeFacilityDetailOptionResponse addResponseFromRoomTypeFacilityDetailOption(RoomTypeFacilityDetailOption roomTypeFacilityDetailOption);

    @Mapping(target = "roomTypeFacilityCategory.id", source = "categoryId")
    RoomTypeFacilityDetailOption roomTypeFacilityDetailOptionFromUpdateRequest(UpdateRoomTypeFacilityDetailOptionRequest request);

    @Mapping(target = "categoryId", source = "roomTypeFacilityCategory.id")
    UpdateRoomTypeFacilityDetailOptionResponse updateResponseFromRoomTypeFacilityDetailOption(RoomTypeFacilityDetailOption roomTypeFacilityDetailOption);

}
