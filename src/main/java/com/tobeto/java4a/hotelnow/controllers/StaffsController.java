package com.tobeto.java4a.hotelnow.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.StaffService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.staffs.AddStaffRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.staffs.AddStaffRequestForAdmin;
import com.tobeto.java4a.hotelnow.services.dtos.requests.staffs.UpdateStaffRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.AddStaffResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.ListStaffResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.UpdateStaffResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/staffs")
@AllArgsConstructor
public class StaffsController extends BaseController {

	private StaffService staffService;

	@GetMapping("/{id}")
	public ResponseEntity<BaseResponse<ListStaffResponse>> getById(@PathVariable int id) {
		ListStaffResponse listStaffResponse = staffService.getResponseById(id);
		if (listStaffResponse == null) {
			return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_STAFF_NOT_FOUND, null);
		} else {
			return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, listStaffResponse);
		}
	}

	@GetMapping("/by-hotel-id/{hotelId}")
	public ResponseEntity<BaseResponse<List<ListStaffResponse>>> getByHotelId(@PathVariable int hotelId) {
		List<ListStaffResponse> listStaffResponses = staffService.getByHotelId(hotelId);
		if (listStaffResponses == null || listStaffResponses.size() == 0) {
			return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_STAFF_NOT_FOUND, null);
		} else {
			return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, listStaffResponses);
		}
	}

	@GetMapping("/get-staffs-of-hotel")
	public ResponseEntity<BaseResponse<List<ListStaffResponse>>> getStaffsOfHotel() {
		List<ListStaffResponse> listStaffResponses = staffService.getStaffsOfHotel();
		if (listStaffResponses == null || listStaffResponses.isEmpty()) {
			return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_STAFF_NOT_FOUND, null);
		} else {
			return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, listStaffResponses);
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<BaseResponse<AddStaffResponse>> add(@RequestBody @Valid AddStaffRequest request) {
		AddStaffResponse addStaffResponse = staffService.add(request);
		return sendResponse(HttpStatus.CREATED, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY, addStaffResponse);
	}

	@PostMapping("/add-staff-for-admin")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<BaseResponse<AddStaffResponse>> addStaffForAdmin(
			@RequestBody @Valid AddStaffRequestForAdmin request) {
		AddStaffResponse addStaffResponse = staffService.addForAdmin(request);
		return sendResponse(HttpStatus.CREATED, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY, addStaffResponse);
	}

	@PutMapping
	public ResponseEntity<BaseResponse<UpdateStaffResponse>> update(@RequestBody @Valid UpdateStaffRequest request) {
		UpdateStaffResponse updateStaffResponse = staffService.update(request);
		return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_UPDATED_SUCCESSFULLY, updateStaffResponse);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<BaseResponse<String>> deleteById(@PathVariable int id) {
		staffService.deleteById(id);
		return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_DELETED_SUCCESSFULLY, null);
	}
}
