package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.abstracts.DistrictService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.districts.ListDistrictResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/districts")
@AllArgsConstructor
public class DistrictsController {

    private DistrictService districtService;

    @GetMapping
    public List<ListDistrictResponse> getAll() {
        return districtService.getAll();
    }

    @GetMapping("/by-city-id/{cityId}")
    public List<ListDistrictResponse> getByCityId(@PathVariable int cityId) {
        return districtService.getByCityId(cityId);
    }

}
