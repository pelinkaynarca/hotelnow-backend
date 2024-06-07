package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.abstracts.HotelImageService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotelimages.AddHotelImageRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages.AddHotelImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages.ListHotelImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.ListHotelPhoneResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel-images")
@AllArgsConstructor
public class HotelImagesController {

    private HotelImageService hotelImageService;

    @GetMapping("/by-hotel-id/{hotelId}")
    public List<ListHotelImageResponse> getByHotelId(@PathVariable int hotelId) {
        return hotelImageService.getByHotelId(hotelId);
    }

    @PostMapping
    public AddHotelImageResponse add(@RequestBody AddHotelImageRequest request) {
        return hotelImageService.add(request);
    }

    @DeleteMapping
    public void delete(@PathVariable int id) {
        hotelImageService.delete(id);
    }



}
