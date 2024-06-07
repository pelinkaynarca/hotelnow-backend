package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.abstracts.MainFacilitySelectionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityselections.AddMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityselections.UpdateMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.AddMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.ListMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.UpdateMainFacilitySelectionResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/main-facility-selections")
@AllArgsConstructor
public class MainFacilitySelectionsController {

    private MainFacilitySelectionService mainFacilitySelectionService;

    @GetMapping("/by-hotel-id/{hotelId}")
    public List<ListMainFacilitySelectionResponse> getByHotelId(@PathVariable int hotelId) {
        return mainFacilitySelectionService.getByHotelId(hotelId);
    }

    @PostMapping
    public AddMainFacilitySelectionResponse add(@RequestBody AddMainFacilitySelectionRequest request) {
        return mainFacilitySelectionService.add(request);
    }

    @PutMapping
    public UpdateMainFacilitySelectionResponse update(@RequestBody UpdateMainFacilitySelectionRequest request) {
        return mainFacilitySelectionService.update(request);
    }

}
