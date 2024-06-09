package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypes.AddRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypes.UpdateRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.AddRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.ListRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.UpdateRoomTypeResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-types")
@AllArgsConstructor
public class RoomTypesController extends BaseController {

    private RoomTypeService roomTypeService;

    @GetMapping("/get-all")
    public ResponseEntity<BaseResponse<List<ListRoomTypeResponse>>> getAll() {
        List<ListRoomTypeResponse> roomTypes = roomTypeService.getAll();
        return sendResponse(HttpStatus.OK.value(), Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, roomTypes);
    }

    @GetMapping("/hotel/{hotelId}")
    public List<ListRoomTypeResponse> getByHotelId(@PathVariable("hotelId") int hotelId) {
        return roomTypeService.getByHotelId(hotelId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<ListRoomTypeResponse>> getById(@PathVariable int id) {
        ListRoomTypeResponse roomType = roomTypeService.getById(id);
        if (roomType == null) {
            return sendResponse(HttpStatus.NOT_FOUND.value(), Messages.Error.CUSTOM_ROOM_TYPE_NOT_FOUND, null);
        } else {
            return sendResponse(HttpStatus.OK.value(), Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, roomType);
        }
    }

    @PostMapping("/create-room-type")
    public ResponseEntity<BaseResponse<AddRoomTypeResponse>> add(@RequestBody @Valid AddRoomTypeRequest request) {
        AddRoomTypeResponse roomTypeResponse = roomTypeService.add(request);
        return sendResponse(HttpStatus.CREATED.value(), Messages.Success.CUSTOM_CREATED_SUCCESSFULLY, roomTypeResponse);
    }

    @PutMapping("/update-room-type")
    public ResponseEntity<BaseResponse<UpdateRoomTypeResponse>> update(@RequestBody @Valid UpdateRoomTypeRequest request) {
        if (roomTypeService.getById(request.getId()) == null) {
            return sendResponse(HttpStatus.BAD_REQUEST.value(), Messages.Error.CUSTOM_ROOM_TYPE_NOT_FOUND, null);
        }

        UpdateRoomTypeResponse roomTypeResponse = roomTypeService.update(request);
        return sendResponse(HttpStatus.OK.value(), Messages.Success.CUSTOM_UPDATED_SUCCESSFULLY, roomTypeResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<String>> delete(@PathVariable int id) {
        ListRoomTypeResponse deletedRoomType = roomTypeService.getById(id);
        if (deletedRoomType == null) {
            return sendResponse(HttpStatus.NOT_FOUND.value(), Messages.Error.CUSTOM_ROOM_TYPE_NOT_FOUND, null);
        } else {
            roomTypeService.delete(id);
            return sendResponse(HttpStatus.OK.value(), Messages.Success.CUSTOM_DELETED_SUCCESSFULLY, null);
        }
    }
}