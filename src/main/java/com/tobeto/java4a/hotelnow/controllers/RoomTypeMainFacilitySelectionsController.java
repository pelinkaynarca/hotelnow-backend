package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeMainFacilityOptionService;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeMainFacilitySelectionService;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityselections.AddRoomTypeMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityselections.UpdateRoomTypeMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.AddRoomTypeMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.ListRoomTypeMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.UpdateRoomTypeMainFacilitySelectionResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-type-main-facility-selections")
@AllArgsConstructor
public class RoomTypeMainFacilitySelectionsController extends BaseController{

    private RoomTypeMainFacilitySelectionService selectionService;
    private RoomTypeService roomTypeService;
    private RoomTypeMainFacilityOptionService optionService;

    @GetMapping("/by-room-type-id/{roomTypeId}")
    public ResponseEntity<BaseResponse<List<ListRoomTypeMainFacilitySelectionResponse>>> getByRoomTypeId(@PathVariable("roomTypeId") int roomTypeId) {
        List<ListRoomTypeMainFacilitySelectionResponse> selections = selectionService.getByRoomTypeId(roomTypeId);
        if (selections == null) {
            return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_TYPE_NOT_FOUND, null);
        } else {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, selections);
        }
    }

//    @GetMapping("/{id}")
//    public RoomTypeMainFacilitySelectionResponse getById(@PathVariable int id) {
//        return roomTypeMainFacilitySelectionService.getById(id);
//    }

    @PostMapping
    public ResponseEntity<BaseResponse<AddRoomTypeMainFacilitySelectionResponse>> add(@RequestBody @Valid AddRoomTypeMainFacilitySelectionRequest request) {

        if (roomTypeService.getById(request.getRoomTypeId()) == null) {
            return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_TYPE_NOT_FOUND, null);
        }
        if (optionService.getById(request.getOptionId()) == null) {
            return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_TYPE_FACILITY_OPTION_NOT_FOUND, null);
        }

        AddRoomTypeMainFacilitySelectionResponse selectionResponse = selectionService.add(request);
        return sendResponse(HttpStatus.CREATED, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, selectionResponse);
    }

    @PutMapping
    public ResponseEntity<BaseResponse<UpdateRoomTypeMainFacilitySelectionResponse>> update(@RequestBody @Valid UpdateRoomTypeMainFacilitySelectionRequest request) {
        if (roomTypeService.getById(request.getRoomTypeId()) == null) {
            return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_TYPE_NOT_FOUND, null);
        }
        if (optionService.getById(request.getOptionId()) == null) {
            return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_TYPE_FACILITY_OPTION_NOT_FOUND, null);
        }
        UpdateRoomTypeMainFacilitySelectionResponse selectionResponse = selectionService.update(request);
        return sendResponse(HttpStatus.CREATED, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, selectionResponse);
    }

//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable int id) {
//        roomTypeMainFacilitySelectionService.delete(id);
//    }
}
