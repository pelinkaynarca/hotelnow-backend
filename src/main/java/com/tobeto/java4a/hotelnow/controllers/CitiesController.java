package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.abstracts.CityService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.cities.ListCityResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@AllArgsConstructor
public class CitiesController {

    private CityService cityService;

    @GetMapping("/get-all")
    public List<ListCityResponse> getAll() {
        return cityService.getAll();

    }
}
