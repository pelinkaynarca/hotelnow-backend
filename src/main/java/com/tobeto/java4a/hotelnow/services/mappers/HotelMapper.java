package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.Hotel;
import com.tobeto.java4a.hotelnow.entities.concretes.MainFacilitySelection;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotels.AddHotelRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotels.UpdateHotelRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.AddHotelResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.ListHotelResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.UpdateHotelResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.ListMainFacilitySelectionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelMapper {

    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    @Mapping(target = "neighborhoodName", source = "hotel.neighborhood.name")
    @Mapping(target = "hotelPhones", source = "hotelPhones")
    @Mapping(target = "hotelImages", source = "hotelImages")
    @Mapping(target = "mainFacilitySelections", source = "mainFacilitySelections")
    ListHotelResponse listResponseFromHotel(Hotel hotel);

    @Mapping(target = "option", source = "mainFacilityOption")
    ListMainFacilitySelectionResponse listResponseFromMainFacilitySelection(MainFacilitySelection mainFacilitySelection);

    @Mapping(target = "neighborhood.id", source = "neighborhoodId")
    Hotel hotelFromAddRequest(AddHotelRequest request);

    @Mapping(target = "neighborhoodName", source = "neighborhood.name")
    AddHotelResponse addResponseFromHotel(Hotel hotel);

    @Mapping(target = "neighborhood.id", source = "request.neighborhoodId")
    Hotel hotelFromUpdateRequest(UpdateHotelRequest request);

    @Mapping(target = "neighborhoodName", source = "neighborhood.name")
    UpdateHotelResponse updateResponseFromHotel(Hotel hotel);
}

