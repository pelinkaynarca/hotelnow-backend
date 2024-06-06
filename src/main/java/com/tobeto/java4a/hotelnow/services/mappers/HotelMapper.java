package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.Hotel;
import com.tobeto.java4a.hotelnow.entities.concretes.HotelPhone;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotels.AddHotelRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotels.UpdateHotelRequest;
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

    @Mapping(target = "phones", source = "hotelPhones")
    @Mapping(target = "neighborhoodName", source = "neighborhood.name")
    ListHotelResponse listResponseFromHotel(Hotel hotel);

    default List<String> mapHotelPhonesToPhones(List<HotelPhone> hotelPhones) {
        return hotelPhones.stream()
                .map(HotelPhone::getPhone)
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

