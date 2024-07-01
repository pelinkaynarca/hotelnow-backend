package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.Hotel;
import com.tobeto.java4a.hotelnow.entities.concretes.MainFacilityOption;
import com.tobeto.java4a.hotelnow.entities.concretes.MainFacilitySelection;
import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityselections.AddMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityselections.UpdateMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityoptions.ListMainFacilityOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.AddMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.ListMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.UpdateMainFacilitySelectionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MainFacilitySelectionMapper {

    MainFacilitySelectionMapper INSTANCE = Mappers.getMapper(MainFacilitySelectionMapper.class);

    @Mapping(target = "optionTitle", source = "mainFacilityOption.title")
    @Mapping(target = "optionId", source = "mainFacilityOption.id")
    ListMainFacilitySelectionResponse listResponseFromMainFacilitySelection(MainFacilitySelection mainFacilitySelection);

    @Mapping(target = "mainFacilityOption.id", source = "request.optionId")
    @Mapping(target = "hotel", source = "hotel")
    @Mapping(target = "display", constant = "true")
    MainFacilitySelection mainFacilitySelectionFromAddRequest(AddMainFacilitySelectionRequest request, Hotel hotel);

    @Mapping(target = "hotelId", source = "hotel.id")
    @Mapping(target = "optionId", source = "mainFacilityOption.id")
    AddMainFacilitySelectionResponse addResponseFromMainFacilitySelection(MainFacilitySelection mainFacilitySelection);

    @Mapping(target = "hotel", ignore = true)
    @Mapping(target = "mainFacilityOption.id", ignore = true)
    void updateMainFacilitySelectionFromUpdateRequest(UpdateMainFacilitySelectionRequest request, @MappingTarget MainFacilitySelection entity);

    @Mapping(target = "optionId", source = "mainFacilityOption.id")
    UpdateMainFacilitySelectionResponse updateResponseFromMainFacilitySelection(MainFacilitySelection mainFacilitySelection);

    default ListMainFacilityOptionResponse mapMainFacilityOptionToResponse(MainFacilityOption mainFacilityOption) {
        return MainFacilityOptionMapper.INSTANCE.listResponseFromMainFacilityOption(mainFacilityOption);
    }

}


