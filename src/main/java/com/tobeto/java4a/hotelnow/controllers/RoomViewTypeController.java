package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomViewTypeService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomviewtypes.AddRoomViewTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomviewtypes.UpdateRoomViewTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomviewtypes.AddRoomViewTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomviewtypes.ListRoomViewTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomviewtypes.UpdateRoomViewTypeResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-view-types")
@AllArgsConstructor
public class RoomViewTypeController extends BaseController{

    private RoomViewTypeService viewTypeService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<ListRoomViewTypeResponse>>> getAll() {
        List<ListRoomViewTypeResponse> viewTypes = viewTypeService.getAll();
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, viewTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<ListRoomViewTypeResponse>> getById(@PathVariable int id) {
        ListRoomViewTypeResponse viewType = viewTypeService.getById(id);
        if (viewType == null) {
            return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_VIEW_TYPE_NOT_FOUND, null);
        } else {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, viewType);
        }
    }

    @PostMapping
    public ResponseEntity<BaseResponse<AddRoomViewTypeResponse>> add(@RequestBody @Valid AddRoomViewTypeRequest request) {
        AddRoomViewTypeResponse badType = viewTypeService.add(request);
        return sendResponse(HttpStatus.CREATED, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY, badType);
    }

    @PutMapping
    public ResponseEntity<BaseResponse<UpdateRoomViewTypeResponse>> update(@RequestBody @Valid UpdateRoomViewTypeRequest request) {
        if (viewTypeService.getById(request.getId()) == null) {
            return sendResponse(HttpStatus.BAD_REQUEST, Messages.Error.CUSTOM_ROOM_VIEW_TYPE_NOT_FOUND, null);
        }

        UpdateRoomViewTypeResponse viewType = viewTypeService.update(request);
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_UPDATED_SUCCESSFULLY, viewType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> delete(@PathVariable int id) {
        viewTypeService.delete(id);
        return sendResponse(HttpStatus.NO_CONTENT, Messages.Success.CUSTOM_DELETED_SUCCESSFULLY, null);
    }
}
