package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.CityService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.cities.ListOnlyCityResponse;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@AllArgsConstructor
public class CitiesController extends BaseController {

	private CityService cityService;

	@GetMapping("/get-all")
	public ResponseEntity<BaseResponse<List<ListOnlyCityResponse>>> getAll() {
		List<ListOnlyCityResponse> listOnlyCityResponses = cityService.getAll();
		if (listOnlyCityResponses == null || listOnlyCityResponses.size() == 0) {
			return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_CITY_NOT_FOUND, null);
		} else {
			return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, listOnlyCityResponses);
		}
	}

	@GetMapping("/only-cities-by-country-id/{countryId}")
	public ResponseEntity<BaseResponse<List<ListOnlyCityResponse>>> getOnlyCitiesByCountryId(
			@PathVariable int countryId) {
		List<ListOnlyCityResponse> listOnlyCityResponses = cityService.getOnlyCitiesByCountryId(countryId);
		if (listOnlyCityResponses == null || listOnlyCityResponses.size() == 0) {
			return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_CITY_NOT_FOUND, null);
		} else {
			return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, listOnlyCityResponses);
		}
	}
}
