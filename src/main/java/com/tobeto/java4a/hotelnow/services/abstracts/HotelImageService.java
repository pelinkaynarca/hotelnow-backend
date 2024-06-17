package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.entities.concretes.HotelImage;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotelimages.AddHotelImageRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages.AddHotelImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages.ListHotelImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.images.ListImageResponse;

import java.util.List;

public interface HotelImageService {

    ListHotelImageResponse getByHotelId(int hotelId);
    List<ListImageResponse> getResponse(List<HotelImage> hotelImages);
    AddHotelImageResponse add(AddHotelImageRequest request);
    void delete(int id);
}
