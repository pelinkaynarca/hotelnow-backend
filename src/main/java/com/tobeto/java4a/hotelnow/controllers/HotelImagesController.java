package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.HotelImageService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotelimages.AddHotelImageRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages.AddHotelImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages.ListHotelImageResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/hotel-images")
@AllArgsConstructor
public class HotelImagesController extends BaseController {

    private final HotelImageService hotelImageService;

    @GetMapping("/by-hotel-id/{hotelId}")
    public ResponseEntity<BaseResponse<ListHotelImageResponse>> getByHotelId(@PathVariable int hotelId) {
        ListHotelImageResponse hotelImagesToBeFound = hotelImageService.getByHotelId(hotelId);
        if (hotelImagesToBeFound != null) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, hotelImagesToBeFound);
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_HOTEL_IMAGE_NOT_FOUND, null);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddHotelImageResponse> add(@RequestParam("image") List<MultipartFile> files) {

        AddHotelImageRequest request = new AddHotelImageRequest();
        request.setFiles(files);

        AddHotelImageResponse response = hotelImageService.add(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<String>> delete(@PathVariable int id) {
        hotelImageService.delete(id);
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_DELETED_SUCCESSFULLY, null);
    }

}
