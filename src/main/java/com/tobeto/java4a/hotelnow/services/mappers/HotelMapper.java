package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.FacilityDetailOption;
import com.tobeto.java4a.hotelnow.entities.concretes.Hotel;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotels.AddHotelRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotels.UpdateHotelRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailoptions.ListFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections.ListFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.AddHotelResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.ListHotelResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.ListHotelResponseForStaff;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.UpdateHotelResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.ListMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.ListReviewResponseByHotelId;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.ListRoomTypeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HotelMapper {

    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    //TODO: update after RoomTypeServiceImpl is fully filled in
    @Mapping(target = "neighborhoodName", source = "hotel.neighborhood.name")
    @Mapping(target = "hotelPhones", source = "hotel.hotelPhones")
    @Mapping(target = "hotelImages", source = "hotel.hotelImages")
    @Mapping(target = "mainFacilitySelections", source = "mainFacilitySelections")
    @Mapping(target = "facilityDetailSelections", source = "facilityDetailSelections")
    @Mapping(target = "reviews", source = "reviews")
    @Mapping(target = "roomTypes", source = "roomTypes")
    ListHotelResponse listResponseFromHotel(Hotel hotel, List<ListReviewResponseByHotelId> reviews, List<ListRoomTypeResponse> roomTypes, List<ListMainFacilitySelectionResponse> mainFacilitySelections, List<ListFacilityDetailSelectionResponse> facilityDetailSelections);

    @Mapping(target = "neighborhoodId", source = "neighborhood.id")
    /* @Mapping(target = "neighborhoodName", source = "neighborhood.name") */
    ListHotelResponseForStaff listResponseForStaffFromHotel(Hotel hotel);

//    @Mapping(target = "option", source = "facilityDetailOption")
//    ListFacilityDetailSelectionResponse listResponseFromFacilityDetailSelection(FacilityDetailSelection facilityDetailSelection);

    @Mapping(target = "categoryTitle", source = "facilityCategory.title")
    ListFacilityDetailOptionResponse listResponseFromFacilityOption(FacilityDetailOption facilityDetailOption);

    @Mapping(target = "neighborhood.id", source = "neighborhoodId")
    Hotel hotelFromAddRequest(AddHotelRequest request);

    @Mapping(target = "neighborhoodName", source = "neighborhood.name")
    AddHotelResponse addResponseFromHotel(Hotel hotel);

    @Mapping(target = "neighborhood.id", source = "request.neighborhoodId")
    Hotel hotelFromUpdateRequest(UpdateHotelRequest request);

    // @Mapping(target = "neighborhoodName", source = "neighborhood.name")
    UpdateHotelResponse updateResponseFromHotel(Hotel hotel);
}

