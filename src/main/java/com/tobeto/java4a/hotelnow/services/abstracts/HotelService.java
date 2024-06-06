package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.requests.hotels.AddHotelRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotels.UpdateHotelRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.ListHotelPhoneResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.AddHotelResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.ListHotelResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.UpdateHotelResponse;

import java.util.List;

public interface HotelService {

    List<ListHotelResponse> getAll();
    List<ListHotelResponse> getByNeighborhoodId(int neighborhoodId);
    List<ListHotelResponse> getByActive(boolean active);
    List<ListHotelResponse> getByStars(Byte stars);
    List<ListHotelPhoneResponse> getPhonesByHotelId(int hotelId);
    AddHotelResponse add(AddHotelRequest request);
    UpdateHotelResponse update(UpdateHotelRequest request);

}
