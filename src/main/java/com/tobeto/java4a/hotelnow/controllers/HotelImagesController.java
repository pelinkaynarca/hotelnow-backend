package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.HotelImageService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotelimages.AddHotelImageRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages.AddHotelImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages.ListHotelImageResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel-images")
@AllArgsConstructor
public class HotelImagesController extends BaseController {

    private HotelImageService hotelImageService;

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<ListHotelImageResponse>> getById(@PathVariable int id) {
        ListHotelImageResponse hotelImageToBeFound = hotelImageService.getById(id);
        if (hotelImageToBeFound != null) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, hotelImageToBeFound);
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_HOTEL_IMAGE_NOT_FOUND, null);
    }

    @GetMapping("/by-hotel-id/{hotelId}")
    public ResponseEntity<BaseResponse<List<ListHotelImageResponse>>> getByHotelId(@PathVariable int hotelId) {
        List<ListHotelImageResponse> hotelImageToBeFound = hotelImageService.getByHotelId(hotelId);
        if (hotelImageToBeFound != null && !hotelImageToBeFound.isEmpty()) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, hotelImageToBeFound);
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_HOTEL_IMAGE_NOT_FOUND, null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BaseResponse<AddHotelImageResponse>> add(@RequestBody @Valid AddHotelImageRequest request) {
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY, hotelImageService.add(request));
    }

    @DeleteMapping
    public ResponseEntity<BaseResponse<String>> delete(@Param("id") int id) {
        ListHotelImageResponse hotelImageToBeDeleted = hotelImageService.getById(id);
        if (hotelImageToBeDeleted != null) {
            hotelImageService.delete(id);
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_DELETED_SUCCESSFULLY, null);
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_HOTEL_IMAGE_NOT_FOUND, null);
    }

}
