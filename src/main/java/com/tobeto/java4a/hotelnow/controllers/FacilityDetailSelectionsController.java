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
import com.tobeto.java4a.hotelnow.services.abstracts.FacilityDetailSelectionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailselections.AddFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailselections.UpdateFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections.AddFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections.ListFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections.UpdateFacilityDetailSelectionResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/facility-detail-selections")
@AllArgsConstructor
public class FacilityDetailSelectionsController extends BaseController {

	private FacilityDetailSelectionService facilityDetailSelectionService;

	@GetMapping("/{id}")
	public ResponseEntity<BaseResponse<ListFacilityDetailSelectionResponse>> getById(@PathVariable int id) {
		ListFacilityDetailSelectionResponse listFacilityDetailSelectionResponse = facilityDetailSelectionService
				.getResponseById(id);
		if (listFacilityDetailSelectionResponse == null) {
			return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_FACILITY_DETAIL_SELECTION_NOT_FOUND, null);
		} else {
			return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY,
					listFacilityDetailSelectionResponse);
		}
	}

	@GetMapping("/by-hotel-id/{hotelId}")
	public ResponseEntity<BaseResponse<List<ListFacilityDetailSelectionResponse>>> getByHotelId(
			@PathVariable int hotelId) {
		List<ListFacilityDetailSelectionResponse> listFacilityDetailSelectionResponses = facilityDetailSelectionService
				.getResponseByHotelId(hotelId);
		if (listFacilityDetailSelectionResponses == null || listFacilityDetailSelectionResponses.size() == 0) {
			return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_FACILITY_DETAIL_SELECTION_NOT_FOUND, null);
		} else {
			return sendResponse(HttpStatus.NOT_FOUND, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY,
					listFacilityDetailSelectionResponses);
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<BaseResponse<AddFacilityDetailSelectionResponse>> add(
			@RequestBody @Valid AddFacilityDetailSelectionRequest request) {
		AddFacilityDetailSelectionResponse addFacilityDetailSelectionResponse = facilityDetailSelectionService
				.add(request);
		return sendResponse(HttpStatus.CREATED, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY,
				addFacilityDetailSelectionResponse);
	}

	@PutMapping
	public ResponseEntity<BaseResponse<UpdateFacilityDetailSelectionResponse>> update(
			@RequestBody @Valid UpdateFacilityDetailSelectionRequest request) {
		UpdateFacilityDetailSelectionResponse updateFacilityDetailSelectionResponse = facilityDetailSelectionService
				.update(request);
		return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_UPDATED_SUCCESSFULLY,
				updateFacilityDetailSelectionResponse);
	}

	@DeleteMapping
	public ResponseEntity<BaseResponse<String>> delete(@PathVariable int id) {
		facilityDetailSelectionService.deleteById(id);
		return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_DELETED_SUCCESSFULLY, null);
	}

}
