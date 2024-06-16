package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeImageService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypeimages.AddRoomTypeImageRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypeimages.AddRoomTypeImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypeimages.ListRoomTypeImageResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/room-type-images")
@AllArgsConstructor
public class RoomTypeImagesController extends  BaseController{

    private RoomTypeImageService roomTypeImageService;

    @GetMapping("/by-room-type/{roomTypeId}")
    public ResponseEntity<BaseResponse<ListRoomTypeImageResponse>> getByRoomTypeId(@PathVariable("roomTypeId") int roomTypeId){
        ListRoomTypeImageResponse imageResponse =  roomTypeImageService.getByRoomTypeId(roomTypeId);
        if (imageResponse == null) {
            return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_TYPE_NOT_FOUND, null);
        } else {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, imageResponse);
        }
    }

    @PostMapping(value = "/upload-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<AddRoomTypeImageResponse>> add(@RequestParam("roomTypeId") int roomTypeId,
                                                                      @RequestParam("image") List<MultipartFile> files) {

        AddRoomTypeImageRequest request = new AddRoomTypeImageRequest();
        request.setRoomTypeId(roomTypeId);
        request.setFiles(files);

        AddRoomTypeImageResponse response = roomTypeImageService.add(request);

        return sendResponse(HttpStatus.CREATED, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY, response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        roomTypeImageService.delete(id);
    }
}
