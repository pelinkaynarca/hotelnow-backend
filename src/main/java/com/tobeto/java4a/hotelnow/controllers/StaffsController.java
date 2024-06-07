package com.tobeto.java4a.hotelnow.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.java4a.hotelnow.services.abstracts.StaffService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.staffs.AddStaffRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.staffs.UpdateStaffRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.AddStaffResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.ListStaffResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.UpdateStaffResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/staffs")
@AllArgsConstructor
public class StaffsController {
	
	private StaffService staffService;
	
	@GetMapping("/{id}")
	public ListStaffResponse getById(@PathVariable int id) {
		return staffService.getById(id);
	}
	
	@GetMapping("/by-hotel-id/{hotelId}")
	public List<ListStaffResponse> getByCustomerId(@PathVariable int hotelId) {
		return staffService.getByHotelId(hotelId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AddStaffResponse add(@RequestBody @Valid AddStaffRequest request) {
		return staffService.add(request);
	}
	
	@PutMapping
	public UpdateStaffResponse add(@RequestBody @Valid UpdateStaffRequest request) {
		return staffService.update(request);
	}

}
