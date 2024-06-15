package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.DistrictService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.districts.ListOnlyDistrictResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/districts")
@AllArgsConstructor
public class DistrictsController extends BaseController {

    private final DistrictService districtService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<ListOnlyDistrictResponse>>> getAll() {
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, districtService.getAll());
    }

    /* might be deleted
     @GetMapping("/by-city-id/{cityId}")
    public ResponseEntity<BaseResponse<List<ListDistrictResponse>>> getByCityId(@PathVariable int cityId) {
        List<ListDistrictResponse> districtsToBeFound = districtService.getByCityId(cityId);
        if (districtsToBeFound != null && !districtsToBeFound.isEmpty()) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, districtsToBeFound);
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_DISTRICT_NOT_FOUND, null);
    } */

    @GetMapping("/by-city-id/{cityId}")
    public ResponseEntity<BaseResponse<List<ListOnlyDistrictResponse>>> getOnlyDistrictsByCityId(@PathVariable int cityId) {
        List<ListOnlyDistrictResponse> districtsToBeFound = districtService.getOnlyDistrictsByCityId(cityId);
        if (districtsToBeFound != null && !districtsToBeFound.isEmpty()) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, districtsToBeFound);
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_DISTRICT_NOT_FOUND, null);
    }

}
