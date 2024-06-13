package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.MainFacilityOption;
import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityoptions.AddMainFacilityOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityoptions.UpdateMainFacilityOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityoptions.AddMainFacilityOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityoptions.ListMainFacilityOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityoptions.UpdateMainFacilityOptionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface  MainFacilityOptionMapper {

    MainFacilityOptionMapper INSTANCE = Mappers.getMapper(MainFacilityOptionMapper.class);


    ListMainFacilityOptionResponse listResponseFromMainFacilityOption(MainFacilityOption mainFacilityOption);

    AddMainFacilityOptionResponse addResponseFromMainFacilityOption(MainFacilityOption mainFacilityOption);

    UpdateMainFacilityOptionResponse updateResponseFromMainFacilityOption(MainFacilityOption mainFacilityOption);
    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "mainFacilitySelections" , ignore = true)
    MainFacilityOption mainFacilityOptionFromAddRequest(AddMainFacilityOptionRequest addMainFacilityOptionRequest);
    @Mapping(target = "mainFacilitySelections" , ignore = true)
    MainFacilityOption mainFacilityOptionFromUpdateRequest(UpdateMainFacilityOptionRequest updateMainFacilityOptionRequest);
}