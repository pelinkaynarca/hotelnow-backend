package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.Hotel;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotels.AddHotelRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotels.UpdateHotelRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages.ListHotelImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.ListHotelPhoneResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.AddHotelResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.ListHotelResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.UpdateHotelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface HotelMapper {

    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    @Mapping(target = "neighborhoodName", source = "hotel.neighborhood.name")
    @Mapping(target = "phoneNumbers", source = "hotelPhoneResponses")
    @Mapping(target = "imageUrls", source = "hotelImageResponses")
    ListHotelResponse listResponseFromHotel(Hotel hotel, List<ListHotelPhoneResponse> hotelPhoneResponses, List<ListHotelImageResponse> hotelImageResponses);

    // maps the phone fields only from ListHotelPhoneResponse DTO
    default List<String> mapHotelPhonesToPhoneFields(List<ListHotelPhoneResponse> hotelPhoneResponses) {
        return hotelPhoneResponses.stream()
                .map(ListHotelPhoneResponse::getPhone)
                .collect(Collectors.toList());
    }

    // maps the url fields only from ListHotelImageResponse DTO
    default List<String> mapHotelImagesToUrlFields(List<ListHotelImageResponse> hotelImageResponses) {
        return hotelImageResponses.stream()
                .map(ListHotelImageResponse::getUrl)
                .collect(Collectors.toList());
    }

    @Mapping(target = "neighborhood.id", source = "neighborhoodId")
    Hotel hotelFromAddRequest(AddHotelRequest request);

    @Mapping(target = "neighborhoodName", source = "neighborhood.name")
    AddHotelResponse addResponseFromHotel(Hotel hotel);

    @Mapping(target = "neighborhood.id", source = "neighborhoodId")
    Hotel hotelFromUpdateRequest(UpdateHotelRequest request);

    @Mapping(target = "neighborhoodName", source = "neighborhood.name")
    UpdateHotelResponse updateResponseFromHotel(Hotel hotel);
}

