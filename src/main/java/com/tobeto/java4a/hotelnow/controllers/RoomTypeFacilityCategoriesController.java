package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeFacilityCategoryService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitycategories.AddRoomTypeFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitycategories.UpdateRoomTypeFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitycategories.AddRoomTypeFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitycategories.ListRoomTypeFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitycategories.UpdateRoomTypeFacilityCategoryResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-type-facility-categories")
@AllArgsConstructor
public class RoomTypeFacilityCategoriesController extends BaseController{

    private RoomTypeFacilityCategoryService roomTypeFacilityCategoryService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<ListRoomTypeFacilityCategoryResponse>>> getAll() {
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, roomTypeFacilityCategoryService.getAll());
    }

    @PostMapping
    public ResponseEntity<BaseResponse<AddRoomTypeFacilityCategoryResponse>> add(
            @RequestBody @Valid AddRoomTypeFacilityCategoryRequest request) {
        AddRoomTypeFacilityCategoryResponse addRoomTypeFacilityCategoryResponse = roomTypeFacilityCategoryService
                .add(request);
        return sendResponse(HttpStatus.CREATED, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY,
                addRoomTypeFacilityCategoryResponse);
    }

    @PutMapping
    public ResponseEntity<BaseResponse<UpdateRoomTypeFacilityCategoryResponse>> update(
            @RequestBody @Valid UpdateRoomTypeFacilityCategoryRequest request) {
        UpdateRoomTypeFacilityCategoryResponse updateRoomTypeFacilityCategoryResponse = roomTypeFacilityCategoryService
                .update(request);
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_UPDATED_SUCCESSFULLY,
                updateRoomTypeFacilityCategoryResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<String>> delete(@PathVariable int id) {
        roomTypeFacilityCategoryService.delete(id);
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_DELETED_SUCCESSFULLY, null);
    }
}
