package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.abstracts.FacilityDetailOptionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailoptions.AddFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailoptions.UpdateFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailoptions.AddFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailoptions.ListFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailoptions.UpdateFacilityDetailOptionResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facility-detail-options")
@AllArgsConstructor
public class FacilityDetailOptionsController {

    private FacilityDetailOptionService facilityDetailOptionService;

    @GetMapping("/by-category-id/{categoryId}")
    public List<ListFacilityDetailOptionResponse> getByCategoryId(@PathVariable int categoryId) {
        return facilityDetailOptionService.getByCategoryId(categoryId);
    }

    @PostMapping
    public AddFacilityDetailOptionResponse add(@RequestBody AddFacilityDetailOptionRequest request) {
        return facilityDetailOptionService.add(request);
    }

    @PutMapping
    public UpdateFacilityDetailOptionResponse update(@RequestBody UpdateFacilityDetailOptionRequest request) {
        return facilityDetailOptionService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        facilityDetailOptionService.delete(id);
    }

}
