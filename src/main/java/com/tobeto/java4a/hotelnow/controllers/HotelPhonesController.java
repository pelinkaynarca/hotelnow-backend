package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.abstracts.HotelPhoneService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotelphones.AddHotelPhoneRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotelphones.UpdateHotelPhoneRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.AddHotelPhoneResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.ListHotelPhoneResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.UpdateHotelPhoneResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel-phones")
@AllArgsConstructor
public class HotelPhonesController {

    private HotelPhoneService hotelPhoneService;

    @GetMapping("/by-hotel-id/{hotelId}")
    public List<ListHotelPhoneResponse> getByHotelId(@PathVariable int hotelId) {
        return hotelPhoneService.getByHotelId(hotelId);
    }

    @PostMapping
    public AddHotelPhoneResponse add(@Valid @RequestBody AddHotelPhoneRequest request) {
        return hotelPhoneService.add(request);
    }

    @PutMapping
    public UpdateHotelPhoneResponse add(@Valid @RequestBody UpdateHotelPhoneRequest request) {
        return hotelPhoneService.update(request);
    }

    @DeleteMapping
    public void delete(@PathVariable int id) {
        hotelPhoneService.delete(id);
    }
}
