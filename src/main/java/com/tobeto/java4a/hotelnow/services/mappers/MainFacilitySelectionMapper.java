package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.MainFacilitySelection;
import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityselections.AddMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityselections.UpdateMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.AddMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.ListMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.UpdateMainFacilitySelectionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MainFacilitySelectionMapper {

    MainFacilitySelectionMapper INSTANCE = Mappers.getMapper(MainFacilitySelectionMapper.class);

    @Mapping(target = "hotelName", source = "hotel.name")
    @Mapping(target = "mainFacilityOptionTitle", source = "mainFacilityOption.title")
    ListMainFacilitySelectionResponse listResponseFromMainFacilitySelection(MainFacilitySelection mainFacilitySelection);

    @Mapping(target = "mainFacilityOption.id", source = "optionId")
    MainFacilitySelection mainFacilitySelectionFromAddRequest(AddMainFacilitySelectionRequest request);

    @Mapping(target = "mainFacilityOptionTitle", source = "mainFacilityOption.title")
    AddMainFacilitySelectionResponse addResponseFromMainFacilitySelection(MainFacilitySelection mainFacilitySelection);

    @Mapping(target = "mainFacilityOption.id", source = "optionId")
    MainFacilitySelection mainFacilitySelectionFromUpdateRequest(UpdateMainFacilitySelectionRequest request);

    @Mapping(target = "mainFacilityOptionTitle", source = "mainFacilityOption.title")
    UpdateMainFacilitySelectionResponse updateResponseFromMainFacilitySelection(MainFacilitySelection mainFacilitySelection);

}
