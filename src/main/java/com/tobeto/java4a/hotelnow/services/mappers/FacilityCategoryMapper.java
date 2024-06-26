package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.FacilityCategory;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitycategories.AddFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitycategories.UpdateFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitycategories.AddFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitycategories.ListFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitycategories.UpdateFacilityCategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FacilityCategoryMapper {

    FacilityCategoryMapper INSTANCE = Mappers.getMapper(FacilityCategoryMapper.class);
    @Mapping(target = "facilityDetailOptionResponse" , source = "facilityDetailOptions")
    ListFacilityCategoryResponse listResponseFromFacilityCategory(FacilityCategory facilityCategory);

    AddFacilityCategoryResponse addResponseFromFacilityCategory(FacilityCategory facilityCategory);

    UpdateFacilityCategoryResponse updateResponseFromFacilityCategory(FacilityCategory facilityCategory);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "facilityDetailOptions" , ignore = true)
    FacilityCategory facilityCategoryFromAddRequest(AddFacilityCategoryRequest addFacilityCategoryRequest);

    @Mapping(target = "facilityDetailOptions" , ignore = true)
    FacilityCategory facilityCategoryFromUpdateRequest(UpdateFacilityCategoryRequest updateFacilityCategoryRequest);

}
