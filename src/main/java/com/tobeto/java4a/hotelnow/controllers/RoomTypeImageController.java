package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeImageService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypeimages.AddRoomTypeImageRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypeimages.AddRoomTypeImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypeimages.ListRoomTypeImageResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-type-images")
@AllArgsConstructor
public class RoomTypeImageController {

    private RoomTypeImageService roomTypeImageService;

    @GetMapping("/{roomTypeId}")
    public List<ListRoomTypeImageResponse> getByRoomTypeId(@PathVariable("roomTypeId") int roomTypeId){
        return roomTypeImageService.getByRoomTypeId(roomTypeId);
    }

    @GetMapping("/{id}")
    public ListRoomTypeImageResponse getById(@PathVariable int id) {
        return roomTypeImageService.getById(id);
    }

    @PostMapping("/create-image")
    @ResponseStatus(HttpStatus.CREATED)
    public AddRoomTypeImageResponse add(@RequestBody @Valid AddRoomTypeImageRequest request) {
        return roomTypeImageService.add(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        roomTypeImageService.delete(id);
    }
}
