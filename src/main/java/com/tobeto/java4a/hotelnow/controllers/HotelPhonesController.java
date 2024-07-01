package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.HotelPhoneService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotelphones.AddHotelPhoneRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotelphones.UpdateHotelPhoneRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.AddHotelPhoneResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.ListHotelPhoneResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.UpdateHotelPhoneResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel-phones")
@AllArgsConstructor
public class HotelPhonesController extends BaseController {

    private final HotelPhoneService hotelPhoneService;

    @GetMapping("/by-hotel-id/{hotelId}")
    public ResponseEntity<BaseResponse<List<ListHotelPhoneResponse>>> getByHotelId(@PathVariable int hotelId) {
        List<ListHotelPhoneResponse> hotelPhonesToBeFound = hotelPhoneService.getByHotelId(hotelId);
        if (hotelPhonesToBeFound != null && !hotelPhonesToBeFound.isEmpty()) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, hotelPhonesToBeFound);
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_HOTEL_PHONE_NOT_FOUND, null);
    }

    @PostMapping
    public ResponseEntity<BaseResponse<AddHotelPhoneResponse>> add(@Valid @RequestBody AddHotelPhoneRequest request) {
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY, hotelPhoneService.add(request));
    }

    @PutMapping
    public ResponseEntity<BaseResponse<UpdateHotelPhoneResponse>> update(@Valid @RequestBody UpdateHotelPhoneRequest request) {
        ListHotelPhoneResponse hotelPhoneToBeFound = hotelPhoneService.getResponseById(request.getId());
        if (hotelPhoneToBeFound != null) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_UPDATED_SUCCESSFULLY, hotelPhoneService.update(request));
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_HOTEL_PHONE_NOT_FOUND, null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<String>> delete(@PathVariable int id) {
        ListHotelPhoneResponse hotelPhoneToBeFound = hotelPhoneService.getResponseById(id);
        if (hotelPhoneToBeFound != null) {
            hotelPhoneService.delete(id);
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_DELETED_SUCCESSFULLY, null);
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_HOTEL_PHONE_NOT_FOUND, null);
    }
}
