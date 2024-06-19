package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeMainFacilityOptionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityoptions.AddRoomTypeMainFacilityOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityoptions.UpdateRoomTypeMainFacilityOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityoptions.AddRoomTypeMainFacilityOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityoptions.ListRoomTypeMainFacilityOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityoptions.UpdateRoomTypeMainFacilityOptionResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-type-main-facility-options")
@AllArgsConstructor
public class RoomTypeMainFacilityOptionsController  extends BaseController{

    private RoomTypeMainFacilityOptionService roomTypeMainFacilityOptionService;

    @GetMapping("/get-all")
    public ResponseEntity<BaseResponse<List<ListRoomTypeMainFacilityOptionResponse>>> getAll() {
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, roomTypeMainFacilityOptionService.getAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BaseResponse<AddRoomTypeMainFacilityOptionResponse>> add(
            @RequestBody @Valid AddRoomTypeMainFacilityOptionRequest request) {
        AddRoomTypeMainFacilityOptionResponse addRoomTypeMainFacilityOptionResponse = roomTypeMainFacilityOptionService
                .add(request);
        return sendResponse(HttpStatus.CREATED, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY,
                addRoomTypeMainFacilityOptionResponse);
    }

    @PutMapping
    public ResponseEntity<BaseResponse<UpdateRoomTypeMainFacilityOptionResponse>> update(
            @RequestBody @Valid UpdateRoomTypeMainFacilityOptionRequest request) {
        UpdateRoomTypeMainFacilityOptionResponse updateRoomTypeMainFacilityOptionResponse = roomTypeMainFacilityOptionService
                .update(request);
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_UPDATED_SUCCESSFULLY,
                updateRoomTypeMainFacilityOptionResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<String>> delete(@PathVariable int id) {
        roomTypeMainFacilityOptionService.delete(id);
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_DELETED_SUCCESSFULLY, null);
    }

}
