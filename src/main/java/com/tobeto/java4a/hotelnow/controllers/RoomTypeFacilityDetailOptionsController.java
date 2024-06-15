package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeFacilityCategoryService;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeFacilityDetailOptionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailoptions.AddRoomTypeFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailoptions.UpdateRoomTypeFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitycategories.ListRoomTypeFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailoptions.AddRoomTypeFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailoptions.ListRoomTypeFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailoptions.UpdateRoomTypeFacilityDetailOptionResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-type-facility-detail-options")
@AllArgsConstructor
public class RoomTypeFacilityDetailOptionsController extends BaseController {

    private final RoomTypeFacilityDetailOptionService roomTypeFacilityDetailOptionService;
    private final RoomTypeFacilityCategoryService roomTypeFacilityCategoryService;

    @GetMapping("/by-category-id/{categoryId}")
    public ResponseEntity<BaseResponse<List<ListRoomTypeFacilityDetailOptionResponse>>> getByCategoryId(@PathVariable int categoryId) {
        ListRoomTypeFacilityCategoryResponse roomTypeFacilityCategory = roomTypeFacilityCategoryService.getResponseById(categoryId);
        List<ListRoomTypeFacilityDetailOptionResponse> roomTypeFacilityDetailOptions = roomTypeFacilityDetailOptionService.getByCategoryId(categoryId);
        if (roomTypeFacilityCategory != null && roomTypeFacilityDetailOptions != null && !roomTypeFacilityDetailOptions.isEmpty()) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, roomTypeFacilityDetailOptions);
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_TYPE_FACILITY_DETAIL_OPTION_NOT_FOUND, null);
    }

    @PostMapping
    public ResponseEntity<BaseResponse<AddRoomTypeFacilityDetailOptionResponse>> add(@RequestBody @Valid AddRoomTypeFacilityDetailOptionRequest request) {
        ListRoomTypeFacilityCategoryResponse roomTypeFacilityCategory = roomTypeFacilityCategoryService.getResponseById(request.getCategoryId());
        if (roomTypeFacilityCategory != null) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY, roomTypeFacilityDetailOptionService.add(request));
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_TYPE_FACILITY_CATEGORY_NOT_FOUND, null);
    }

    @PutMapping
    public ResponseEntity<BaseResponse<UpdateRoomTypeFacilityDetailOptionResponse>> update(@RequestBody @Valid UpdateRoomTypeFacilityDetailOptionRequest request) {
        ListRoomTypeFacilityDetailOptionResponse roomTypeFacilityDetailOption = roomTypeFacilityDetailOptionService.getResponseById(request.getId());
        if (roomTypeFacilityDetailOption != null) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_UPDATED_SUCCESSFULLY, roomTypeFacilityDetailOptionService.update(request));
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_TYPE_FACILITY_DETAIL_OPTION_NOT_FOUND, null);
    }

    @DeleteMapping
    public ResponseEntity<BaseResponse<String>> delete(@Param("id") int id) {
        ListRoomTypeFacilityDetailOptionResponse roomTypeFacilityDetailOptionToBeFound = roomTypeFacilityDetailOptionService.getResponseById(id);
        if (roomTypeFacilityDetailOptionToBeFound != null) {
            roomTypeFacilityDetailOptionService.delete(id);
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_DELETED_SUCCESSFULLY, null);
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_TYPE_FACILITY_DETAIL_OPTION_NOT_FOUND, null);
    }

}
