package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.HotelService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotels.AddHotelRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotels.UpdateHotelRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.AddHotelResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.ListHotelResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.UpdateHotelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@AllArgsConstructor
public class HotelsController extends BaseController {

   private final HotelService hotelService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<ListHotelResponse>>> getAll() {
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, hotelService.getAll());
    }

    @GetMapping("/by-neighborhood-id/{neighborhoodId}")
    public ResponseEntity<BaseResponse<List<ListHotelResponse>>> getByNeighborhoodId(@PathVariable int neighborhoodId) {
        List<ListHotelResponse> hotelsToBeFound = hotelService.getByNeighborhoodId(neighborhoodId);
        if (hotelsToBeFound != null && !hotelsToBeFound.isEmpty()) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, hotelsToBeFound);
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_HOTEL_NOT_FOUND, null);
    }

    @GetMapping("/by-active-status/{active}")
    public ResponseEntity<BaseResponse<List<ListHotelResponse>>> getByActive(@PathVariable boolean active) {
        List<ListHotelResponse> hotelsToBeFound = hotelService.getByActive(active);
        if (hotelsToBeFound != null && !hotelsToBeFound.isEmpty()) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, hotelsToBeFound);
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_HOTEL_NOT_FOUND, null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<ListHotelResponse>> getResponseById(@PathVariable int id) {
        ListHotelResponse hotelToBeFound = hotelService.getResponseById(id);
        if (hotelToBeFound != null) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, hotelToBeFound);
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_HOTEL_NOT_FOUND, null);
    }

    @GetMapping("/by-stars/{stars}")
    public ResponseEntity<BaseResponse<List<ListHotelResponse>>> getByStars(@PathVariable Byte stars) {
        List<ListHotelResponse> hotelsToBeFound = hotelService.getByStars(stars);
        if (hotelsToBeFound != null && !hotelsToBeFound.isEmpty()) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, hotelsToBeFound);
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_HOTEL_NOT_FOUND, null);
    }

    @PostMapping
    public ResponseEntity<BaseResponse<AddHotelResponse>> add(@RequestBody @Valid AddHotelRequest request) {
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY, hotelService.add(request));
    }

    @PutMapping
    public ResponseEntity<BaseResponse<UpdateHotelResponse>> update(@RequestBody @Valid UpdateHotelRequest request) {
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_UPDATED_SUCCESSFULLY, hotelService.update(request));
    }

}



