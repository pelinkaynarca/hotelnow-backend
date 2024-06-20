package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomService;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.rooms.AddRoomRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.rooms.UpdateRoomRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.rooms.AddRoomResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.rooms.ListRoomResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.rooms.UpdateRoomResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@AllArgsConstructor
public class RoomsController extends BaseController{

    private RoomService roomService;
    private RoomTypeService roomTypeService;

    @GetMapping("/by-room-type-id/{roomTypeId}")
    public ResponseEntity<BaseResponse<List<ListRoomResponse>>> getResponseByRoomTypeId(@PathVariable int roomTypeId) {
        if (roomTypeService.getById(roomTypeId) == null) {
            return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_TYPE_NOT_FOUND, null);
        }

        List<ListRoomResponse> roomResponses = roomService.getResponseByRoomTypeId(roomTypeId);
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, roomResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<ListRoomResponse>> getById(@PathVariable int id) {
        ListRoomResponse response = roomService.getById(id);
        if (response == null) {
            return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_NOT_FOUND, null);
        }
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, response);
    }

    @PostMapping
    public ResponseEntity<BaseResponse<AddRoomResponse>> add(@RequestBody @Valid AddRoomRequest request) {
        if (roomTypeService.getById(request.getRoomTypeId()) == null) {
            return sendResponse(HttpStatus.BAD_REQUEST, Messages.Error.CUSTOM_ROOM_TYPE_NOT_FOUND, null);
        }

        AddRoomResponse response = roomService.add(request);
        return sendResponse(HttpStatus.CREATED, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY, response);
    }

    @PutMapping
    public ResponseEntity<BaseResponse<UpdateRoomResponse>> update(@RequestBody @Valid UpdateRoomRequest request) {
        if (roomTypeService.getById(request.getRoomTypeId()) == null) {
            return sendResponse(HttpStatus.BAD_REQUEST, Messages.Error.CUSTOM_ROOM_TYPE_NOT_FOUND, null);
        }

        UpdateRoomResponse response = roomService.update(request);
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_UPDATED_SUCCESSFULLY, response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> delete(@PathVariable int id) {
        roomService.delete(id);
        return sendResponse(HttpStatus.NO_CONTENT, Messages.Success.CUSTOM_DELETED_SUCCESSFULLY, null);
    }
}