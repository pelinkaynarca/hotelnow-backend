package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.CountryService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.countries.ListOnlyCountryResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@AllArgsConstructor
public class CountriesController extends BaseController {

    private CountryService countryService;

    @GetMapping("/get-all")
    public List<ListOnlyCountryResponse> getAll() {
        return countryService.getAll();

    }

    @GetMapping("/by-country-id/{countryId}")
    public ResponseEntity<BaseResponse<ListOnlyCountryResponse>> getOnlyCountryById(
            @PathVariable int countryId) {
        ListOnlyCountryResponse listOnlyCountryResponses = countryService.getOnlyCountryById(countryId);
        if (listOnlyCountryResponses == null) {
            return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_COUNTRY_NOT_FOUND, null);
        } else {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, listOnlyCountryResponses);
        }
    }
}