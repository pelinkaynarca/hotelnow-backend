package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.abstracts.NeighborhoodService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.districts.ListDistrictResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.neighborhoods.ListNeighborhoodResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/neighborhoods")
@AllArgsConstructor
public class NeighborhoodsController {

    private NeighborhoodService neighborhoodService;

    @GetMapping
    public List<ListNeighborhoodResponse> getAll() {
        return neighborhoodService.getAll();
    }

    @GetMapping("/by-district-id/{districtId}")
    public List<ListNeighborhoodResponse> getByDistrictId(@PathVariable int districtId) {
        return neighborhoodService.getByDistrictId(districtId);
    }

}
