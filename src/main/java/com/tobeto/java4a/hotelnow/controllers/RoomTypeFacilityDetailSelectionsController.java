package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeFacilityDetailOptionService;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeFacilityDetailSelectionService;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailselections.AddRoomTypeFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailselections.UpdateRoomTypeFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.AddRoomTypeFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.ListRoomTypeFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.UpdateRoomTypeFacilityDetailSelectionResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/room-type-facility-detail-selections")
@AllArgsConstructor
public class RoomTypeFacilityDetailSelectionsController extends BaseController{

    private RoomTypeFacilityDetailSelectionService selectionService;
    private RoomTypeService roomTypeService;
    private RoomTypeFacilityDetailOptionService optionService;

    @GetMapping("/by-room-type-id/{roomTypeById}")
    public ResponseEntity<BaseResponse<List<ListRoomTypeFacilityDetailSelectionResponse>>> getByRoomTypeId(@PathVariable int roomTypeById) {
        List<ListRoomTypeFacilityDetailSelectionResponse> details = selectionService.getByRoomTypeId(roomTypeById);
        if (details == null) {
            return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_TYPE_NOT_FOUND, null);
        } else {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, details);
        }
    }

//    @GetMapping("/{id}")
//    public RoomTypeFacilityDetailSelectionResponse getById(@PathVariable int id) {
//        return roomTypeFacilityDetailSelectionService.getById(id);
//    }

    @PostMapping
    public ResponseEntity<BaseResponse<List<AddRoomTypeFacilityDetailSelectionResponse>>> add(@RequestBody @Valid List<AddRoomTypeFacilityDetailSelectionRequest> requests) {
        List<AddRoomTypeFacilityDetailSelectionResponse> responses = new ArrayList<>();

        for(AddRoomTypeFacilityDetailSelectionRequest request : requests){
            if (roomTypeService.getById(request.getRoomTypeId()) == null) {
                return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_TYPE_NOT_FOUND, null);
            }
            if (optionService.getResponseById(request.getOptionId()) == null) {
                return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_TYPE_FACILITY_DETAIL_OPTION_NOT_FOUND, null);
            }
            AddRoomTypeFacilityDetailSelectionResponse selectionResponse = selectionService.add(request);
            responses.add(selectionResponse);
        }

        return sendResponse(HttpStatus.CREATED, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY, responses);
    }

    @PutMapping
    public ResponseEntity<BaseResponse<List<UpdateRoomTypeFacilityDetailSelectionResponse>>> update(@RequestBody @Valid List<UpdateRoomTypeFacilityDetailSelectionRequest> requests) {
        List<UpdateRoomTypeFacilityDetailSelectionResponse> responses = new ArrayList<>();

        for (UpdateRoomTypeFacilityDetailSelectionRequest request : requests) {
            if (roomTypeService.getById(request.getRoomTypeId()) == null) {
                return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_TYPE_NOT_FOUND, null);
            }
            if (optionService.getResponseById(request.getOptionId()) == null) {
                return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_TYPE_FACILITY_DETAIL_OPTION_NOT_FOUND, null);
            }

            UpdateRoomTypeFacilityDetailSelectionResponse selectionResponse = selectionService.update(request);
            responses.add(selectionResponse);
        }

        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, responses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> delete(@PathVariable int id) {
        selectionService.delete(id);
        return sendResponse(HttpStatus.NO_CONTENT, Messages.Success.CUSTOM_DELETED_SUCCESSFULLY, null);
    }
}
