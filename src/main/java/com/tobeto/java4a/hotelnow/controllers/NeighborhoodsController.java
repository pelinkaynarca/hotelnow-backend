package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.NeighborhoodService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.neighborhoods.ListNeighborhoodResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/neighborhoods")
@AllArgsConstructor
public class NeighborhoodsController extends BaseController {

    private NeighborhoodService neighborhoodService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<ListNeighborhoodResponse>>> getAll() {
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, neighborhoodService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<ListNeighborhoodResponse>> getById(@PathVariable int id) {
        ListNeighborhoodResponse neighborhoodToBeFound = neighborhoodService.getResponseById(id);
        if (neighborhoodToBeFound != null) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, neighborhoodToBeFound);
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_NEIGHBORHOOD_NOT_FOUND, null);
    }

    @GetMapping("/by-district-id/{districtId}")
    public ResponseEntity<BaseResponse<List<ListNeighborhoodResponse>>> getByDistrictId(@PathVariable int districtId) {
        List<ListNeighborhoodResponse> neighborhoodsToBeFound = neighborhoodService.getByDistrictId(districtId);
        if (neighborhoodsToBeFound != null && !neighborhoodsToBeFound.isEmpty()) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, neighborhoodsToBeFound);
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_NEIGHBORHOOD_NOT_FOUND, null);
    }

}
