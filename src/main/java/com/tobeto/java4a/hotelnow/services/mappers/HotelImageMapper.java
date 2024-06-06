package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.HotelImage;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages.ListHotelImageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface HotelImageMapper {

    @Mapping(target = "hotelName", source = "hotel.name")
    ListHotelImageResponse listResponseFromHotelImage(HotelImage hotelImage);

}
