package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeImageService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypeimages.AddRoomTypeImageRequest;
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
public class RoomTypeImagesController {

    private RoomTypeImageService roomTypeImageService;

    @GetMapping("/room-types/{roomTypeId}")
    public ListRoomTypeImageResponse getByRoomTypeId(@PathVariable("roomTypeId") int roomTypeId){
        return roomTypeImageService.getByRoomTypeId(roomTypeId);
    }

    @GetMapping("/{id}")
    public ListRoomTypeImageResponse getById(@PathVariable int id) {
        return roomTypeImageService.getById(id);
    }

    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddRoomTypeImageResponse> add(@RequestParam("roomTypeId") int roomTypeId,
                                                        @RequestParam("file") List<MultipartFile> files) {

        AddRoomTypeImageRequest request = new AddRoomTypeImageRequest();
        request.setRoomTypeId(roomTypeId);
        request.setFiles(files);

        AddRoomTypeImageResponse response = roomTypeImageService.add(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        roomTypeImageService.delete(id);
    }
}
