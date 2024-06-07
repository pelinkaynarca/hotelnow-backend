package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.requests.hotelphones.AddHotelPhoneRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotelphones.UpdateHotelPhoneRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.AddHotelPhoneResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.ListHotelPhoneResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.UpdateHotelPhoneResponse;

import java.util.List;

public interface HotelPhoneService {

    List<ListHotelPhoneResponse> getByHotelId(int hotelId);
    AddHotelPhoneResponse add(AddHotelPhoneRequest request);
    UpdateHotelPhoneResponse update(UpdateHotelPhoneRequest request);
    void delete(int id);

}
