package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.HotelPhone;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.ListHotelPhoneResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface HotelPhoneMapper {

    @Mapping(target = "hotelName", source = "hotel.name")
    ListHotelPhoneResponse listResponseFromHotelPhone(HotelPhone hotelPhone);

}
