package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.repositories.HotelPhoneRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.HotelPhoneService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotelphones.AddHotelPhoneRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotelphones.UpdateHotelPhoneRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.AddHotelPhoneResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.ListHotelPhoneResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.UpdateHotelPhoneResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class HotelPhoneServiceImpl implements HotelPhoneService {

    private HotelPhoneRepository hotelPhoneRepository;

    @Override
    public List<ListHotelPhoneResponse> getByHotelId(int hotelId) {
        return List.of();
    }

    @Override
    public AddHotelPhoneResponse add(AddHotelPhoneRequest request) {
        return null;
    }

    @Override
    public UpdateHotelPhoneResponse update(UpdateHotelPhoneRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
