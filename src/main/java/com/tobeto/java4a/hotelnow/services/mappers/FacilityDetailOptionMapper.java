package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.FacilityDetailOption;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailoptions.AddFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailoptions.UpdateFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailoptions.AddFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailoptions.ListFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailoptions.UpdateFacilityDetailOptionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FacilityDetailOptionMapper {

    FacilityDetailOptionMapper INSTANCE = Mappers.getMapper(FacilityDetailOptionMapper.class);

    @Mapping(target = "categoryTitle", source = "facilityCategory.title")
    ListFacilityDetailOptionResponse listResponseFromFacilityDetailOption(FacilityDetailOption facilityDetailOption);

    @Mapping(target = "facilityCategory.id", source = "categoryId")
    FacilityDetailOption facilityDetailOptionFromAddRequest(AddFacilityDetailOptionRequest facilityDetailOption);

    @Mapping(target = "categoryTitle", source = "facilityCategory.title")
    AddFacilityDetailOptionResponse addResponseFromFacilityDetailOption(FacilityDetailOption facilityDetailOption);

    @Mapping(target = "facilityCategory.id", source = "categoryId")
    FacilityDetailOption facilityDetailOptionFromUpdateRequest(UpdateFacilityDetailOptionRequest facilityDetailOption);

    @Mapping(target = "categoryTitle", source = "facilityCategory.title")
    UpdateFacilityDetailOptionResponse updateResponseFromFacilityDetailOption(FacilityDetailOption facilityDetailOption);




}
