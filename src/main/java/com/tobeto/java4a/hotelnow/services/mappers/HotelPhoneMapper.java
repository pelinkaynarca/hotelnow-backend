package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.Hotel;
import com.tobeto.java4a.hotelnow.entities.concretes.HotelPhone;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotelphones.AddHotelPhoneRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotelphones.UpdateHotelPhoneRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.AddHotelPhoneResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.ListHotelPhoneResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.UpdateHotelPhoneResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelPhoneMapper {

    HotelPhoneMapper INSTANCE = Mappers.getMapper(HotelPhoneMapper.class);

    ListHotelPhoneResponse listResponseFromHotelPhone(HotelPhone hotelPhone);

    @Mapping(target = "hotel", source = "hotel")
    @Mapping(target = "id", ignore = true)
    HotelPhone hotelPhoneFromAddRequest(AddHotelPhoneRequest request, Hotel hotel);

    @Mapping(target = "hotelId", source = "hotel.id")
    AddHotelPhoneResponse addResponseFromHotelPhone(HotelPhone hotelPhone);

    @Mapping(target = "id", source = "request.id")
    @Mapping(target = "hotel", source = "hotel")
    HotelPhone hotelPhoneFromUpdateRequest(UpdateHotelPhoneRequest request, Hotel hotel);

    UpdateHotelPhoneResponse updateResponseFromHotelPhone(HotelPhone hotelPhone);
}
