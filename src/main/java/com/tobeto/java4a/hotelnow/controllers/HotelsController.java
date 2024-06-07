package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.abstracts.HotelService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotels.AddHotelRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotels.UpdateHotelRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages.ListHotelImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.ListHotelPhoneResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.AddHotelResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.ListHotelResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.UpdateHotelResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@AllArgsConstructor
public class HotelsController {

   private HotelService hotelService;

    @GetMapping
    public List<ListHotelResponse> getAll() {
        return hotelService.getAll();
    }

    @GetMapping("/by-neighborhood-id/{neighborhoodId}")
    public List<ListHotelResponse> getByNeighborhoodId(@PathVariable int neighborhoodId) {
        return hotelService.getByNeighborhoodId(neighborhoodId);
    }

    @GetMapping("/by-active-status/{active}")
    public List<ListHotelResponse> getByActive(@PathVariable boolean active) {
        return hotelService.getByActive(active);
    }

    @GetMapping("/by-stars/{stars}")
    public List<ListHotelResponse> getByStars(@PathVariable Byte stars) {
        return hotelService.getByStars(stars);
    }

    @PostMapping
    public AddHotelResponse add(@RequestBody AddHotelRequest request) {
        return hotelService.add(request);
    }

    @PutMapping
    public UpdateHotelResponse update(@RequestBody UpdateHotelRequest request) {
        return hotelService.update(request);
    }

}



