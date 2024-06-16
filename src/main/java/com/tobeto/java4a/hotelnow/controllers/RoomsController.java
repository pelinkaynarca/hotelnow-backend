package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.abstracts.RoomService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.rooms.AddRoomRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.rooms.UpdateRoomRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.rooms.AddRoomResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.rooms.ListRoomResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.rooms.UpdateRoomResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@AllArgsConstructor
public class RoomsController {

    private RoomService roomService;

    @GetMapping("/by-room-type/{roomTypeId}")
    public List<ListRoomResponse> getResponseByRoomTypeId (@PathVariable int roomTypeId) {
        return roomService.getResponseByRoomTypeId(roomTypeId);
    }

    @GetMapping("/{id}")
    public ListRoomResponse getById(@PathVariable int id) {
        return roomService.getById(id);
    }

    @PostMapping("/create-room")
    @ResponseStatus(HttpStatus.CREATED)
    public AddRoomResponse add(@RequestBody @Valid AddRoomRequest request) {
        return roomService.add(request);
    }

    @PutMapping("/update-room")
    public UpdateRoomResponse update(@RequestBody @Valid UpdateRoomRequest request) {
        return roomService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        roomService.delete(id);
    }
}