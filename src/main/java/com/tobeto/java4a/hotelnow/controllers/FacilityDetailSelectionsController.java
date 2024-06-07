package com.tobeto.java4a.hotelnow.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.java4a.hotelnow.services.abstracts.FacilityDetailSelectionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailselections.AddFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailselections.UpdateFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections.AddFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections.ListFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections.UpdateFacilityDetailSelectionResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/facility-detail-selections")
@AllArgsConstructor
public class FacilityDetailSelectionsController {

	private FacilityDetailSelectionService facilityDetailSelectionService;

	@GetMapping("/{id}")
	public ListFacilityDetailSelectionResponse getById(@PathVariable int id) {
		return facilityDetailSelectionService.getById(id);
	}

	@GetMapping("/by-hotel-id/{hotelId}")
	public List<ListFacilityDetailSelectionResponse> getByHotelId(@PathVariable int hotelId) {
		return facilityDetailSelectionService.getByHotelId(hotelId);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AddFacilityDetailSelectionResponse add(@RequestBody @Valid AddFacilityDetailSelectionRequest request) {
		return facilityDetailSelectionService.add(request);
	}
	
	@PutMapping
	public UpdateFacilityDetailSelectionResponse update(@RequestBody @Valid UpdateFacilityDetailSelectionRequest request) {
		return facilityDetailSelectionService.update(request);
	}
	
	@DeleteMapping
	public void delete(@PathVariable int id) {
		facilityDetailSelectionService.delete(id);
	}

}
