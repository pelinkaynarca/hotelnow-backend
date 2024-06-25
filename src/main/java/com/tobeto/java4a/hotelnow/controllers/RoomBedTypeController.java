package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomBedTypeService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roombedtypes.AddRoomBedTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roombedtypes.UpdateRoomBedTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roombedtypes.AddRoomBedTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roombedtypes.ListRoomBedTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roombedtypes.UpdateRoomBedTypeResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-bed-types")
@AllArgsConstructor
public class RoomBedTypeController extends BaseController {

    private RoomBedTypeService bedTypeService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<ListRoomBedTypeResponse>>> getAll() {
        List<ListRoomBedTypeResponse> bedTypes = bedTypeService.getAll();
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, bedTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<ListRoomBedTypeResponse>> getById(@PathVariable int id) {
        ListRoomBedTypeResponse bedType = bedTypeService.getById(id);
        if (bedType == null) {
            return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_BED_TYPE_NOT_FOUND, null);
        } else {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, bedType);
        }
    }

    @PostMapping
    public ResponseEntity<BaseResponse<AddRoomBedTypeResponse>> add(@RequestBody @Valid AddRoomBedTypeRequest request) {
        AddRoomBedTypeResponse bedType = bedTypeService.add(request);
        return sendResponse(HttpStatus.CREATED, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY, bedType);
    }

    @PutMapping
    public ResponseEntity<BaseResponse<UpdateRoomBedTypeResponse>> update(@RequestBody @Valid UpdateRoomBedTypeRequest request) {
        if (bedTypeService.getById(request.getId()) == null) {
            return sendResponse(HttpStatus.BAD_REQUEST, Messages.Error.CUSTOM_ROOM_BED_TYPE_NOT_FOUND, null);
        }

        UpdateRoomBedTypeResponse bedType = bedTypeService.update(request);
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_UPDATED_SUCCESSFULLY, bedType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> delete(@PathVariable int id) {
        bedTypeService.delete(id);
        return sendResponse(HttpStatus.NO_CONTENT, Messages.Success.CUSTOM_DELETED_SUCCESSFULLY, null);
    }
}
