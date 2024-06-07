package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.repositories.HotelImageRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.HotelImageService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotelimages.AddHotelImageRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages.AddHotelImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages.ListHotelImageResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class HotelImageServiceImpl implements HotelImageService {

    private HotelImageRepository hotelImageRepository;

    @Override
    public AddHotelImageResponse add(AddHotelImageRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<ListHotelImageResponse> getByHotelId(int hotelId) {
        return List.of();
    }
}
