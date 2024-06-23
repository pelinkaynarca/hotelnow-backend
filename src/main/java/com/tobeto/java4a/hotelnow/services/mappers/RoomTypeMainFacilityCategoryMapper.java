package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeMainFacilityCategory;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilitycategories.AddRoomTypeMainFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilitycategories.UpdateRoomTypeMainFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilitycategories.AddRoomTypeMainFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilitycategories.ListRoomTypeMainFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilitycategories.UpdateRoomTypeMainFacilityCategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomTypeMainFacilityCategoryMapper {

    RoomTypeMainFacilityCategoryMapper INSTANCE = Mappers.getMapper(RoomTypeMainFacilityCategoryMapper.class);

    @Mapping(target = "roomTypeMainFacilityOption" , source = "roomTypeMainFacilityOptions")
    ListRoomTypeMainFacilityCategoryResponse listResponseFromRoomTypeMainFacilityCategory(RoomTypeMainFacilityCategory category);

    @Mapping(target = "id", ignore = true)
    RoomTypeMainFacilityCategory roomTypeMainFacilityCategoryFromAddRequest (AddRoomTypeMainFacilityCategoryRequest request );

    AddRoomTypeMainFacilityCategoryResponse addResponseFromRoomTypeMainFacilityCategory(RoomTypeMainFacilityCategory category);

    RoomTypeMainFacilityCategory roomTypeMainFacilityCategoryFromUpdateRequest(UpdateRoomTypeMainFacilityCategoryRequest request);

    UpdateRoomTypeMainFacilityCategoryResponse updateResponseFromRoomTypeMainFacilityCategory(RoomTypeMainFacilityCategory category);
}
