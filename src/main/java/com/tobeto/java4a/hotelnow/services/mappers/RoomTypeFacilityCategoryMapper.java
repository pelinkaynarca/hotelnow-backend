package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeFacilityCategory;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitycategories.AddRoomTypeFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitycategories.UpdateRoomTypeFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitycategories.AddRoomTypeFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitycategories.ListRoomTypeFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitycategories.UpdateRoomTypeFacilityCategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomTypeFacilityCategoryMapper {

    RoomTypeFacilityCategoryMapper INSTANCE = Mappers.getMapper(RoomTypeFacilityCategoryMapper.class);
    @Mapping(target = "roomTypeFacilityOptionResponse" , source = "roomTypeFacilityDetailOptions")
    ListRoomTypeFacilityCategoryResponse listResponseFromRoomTypeFacilityCategory(RoomTypeFacilityCategory roomTypeFacilityCategory);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roomTypeFacilityDetailOptions", ignore = true)
    RoomTypeFacilityCategory roomTypeFacilityCategoryFromAddRequest (AddRoomTypeFacilityCategoryRequest request );

    AddRoomTypeFacilityCategoryResponse addResponseFromRoomTypeFacilityCategory(RoomTypeFacilityCategory roomTypeFacilityCategory);
    @Mapping(target = "roomTypeFacilityDetailOptions", ignore = true)
    RoomTypeFacilityCategory roomTypeFacilityCategoryFromUpdateRequest(UpdateRoomTypeFacilityCategoryRequest request);

    UpdateRoomTypeFacilityCategoryResponse updateResponseFromRoomTypeFacilityCategory(RoomTypeFacilityCategory roomTypeFacilityCategory);
}
