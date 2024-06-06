package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.repositories.HotelRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.HotelService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotels.AddHotelRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotels.UpdateHotelRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.ListHotelPhoneResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.AddHotelResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.ListHotelResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.UpdateHotelResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;

    @Override
    public List<ListHotelResponse> getAll() {
        return List.of();
    }

    @Override
    public List<ListHotelResponse> getByNeighborhoodId(int neighborhoodId) {
        return List.of();
    }

    @Override
    public List<ListHotelResponse> getByActive(boolean active) {
        return List.of();
    }

    @Override
    public List<ListHotelResponse> getByStars(Byte stars) {
        return List.of();
    }

    @Override
    public List<ListHotelPhoneResponse> getPhonesByHotelId(int hotelId) {
        return List.of();
    }

    @Override
    public AddHotelResponse add(AddHotelRequest request) {
        return null;
    }

    @Override
    public UpdateHotelResponse update(UpdateHotelRequest request) {
        return null;
    }

}
