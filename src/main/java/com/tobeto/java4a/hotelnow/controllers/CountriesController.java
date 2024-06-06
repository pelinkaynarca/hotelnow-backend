package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.abstracts.CountryService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.countries.ListCountryResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@AllArgsConstructor
public class CountriesController {

    private CountryService countryService;

    @GetMapping("/get-all")
    public List<ListCountryResponse> getAll() {
        return countryService.getAll();

    }
}
