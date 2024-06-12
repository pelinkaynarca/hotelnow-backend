package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.Hotel;
import com.tobeto.java4a.hotelnow.entities.concretes.HotelImage;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotelimages.AddHotelImageRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages.AddHotelImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages.ListHotelImageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelImageMapper {

    HotelImageMapper INSTANCE = Mappers.getMapper(HotelImageMapper.class);

    @Mapping(target = "hotelId", source = "hotel.id")
    @Mapping(target = "hotelName", source = "hotel.name")
    ListHotelImageResponse listResponseFromHotelImage(HotelImage hotelImage);

    @Mapping(target = "hotel", source = "hotel")
    HotelImage hotelImageFromAddRequest(AddHotelImageRequest request, Hotel hotel);

    @Mapping(target = "hotelId", source = "hotel.id")
    AddHotelImageResponse addResponseFromHotelImage(HotelImage hotelImage);

}
