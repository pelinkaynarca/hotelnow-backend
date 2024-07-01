package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.entities.concretes.Hotel;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotels.AddHotelRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotels.UpdateHotelRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.AddHotelResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.ListHotelResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.ListHotelResponseForStaff;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.UpdateHotelResponse;

import java.util.List;

public interface HotelService {

    List<ListHotelResponse> getAll();
    List<ListHotelResponse> getByNeighborhoodId(int neighborhoodId);
    List<ListHotelResponse> getByActive(boolean active);
    List<ListHotelResponse> getByStars(byte stars);
    ListHotelResponse getResponseById(int id);
    ListHotelResponseForStaff getResponseForStaff();
    List<ListHotelResponse> getByFilter(Integer cityId, Byte capacity, Byte stars);
    Hotel getById(int id);
    AddHotelResponse add(AddHotelRequest request);
    UpdateHotelResponse update(UpdateHotelRequest request);

}
