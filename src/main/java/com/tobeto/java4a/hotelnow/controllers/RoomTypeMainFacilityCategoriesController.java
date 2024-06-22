package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeMainFacilityCategory;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeMainFacilityCategoryService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilitycategories.AddRoomTypeMainFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilitycategories.UpdateRoomTypeMainFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilitycategories.AddRoomTypeMainFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilitycategories.ListRoomTypeMainFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilitycategories.UpdateRoomTypeMainFacilityCategoryResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-type-main-facility-categories")
@AllArgsConstructor
public class RoomTypeMainFacilityCategoriesController extends BaseController {

    private RoomTypeMainFacilityCategoryService categoryService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<ListRoomTypeMainFacilityCategoryResponse>>> getAll() {
        List<ListRoomTypeMainFacilityCategoryResponse> categories = categoryService.getAll();
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<RoomTypeMainFacilityCategory>> getById(@PathVariable int id) {
        RoomTypeMainFacilityCategory category = categoryService.getById(id);
        if (category == null) {
            return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_TYPE_MAIN_FACILITY_CATEGORY_NOT_FOUND, null);
        } else {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, category);
        }
    }

    @PostMapping
    public ResponseEntity<BaseResponse<AddRoomTypeMainFacilityCategoryResponse>> add(@RequestBody @Valid AddRoomTypeMainFacilityCategoryRequest request) {
        AddRoomTypeMainFacilityCategoryResponse category = categoryService.add(request);
        return sendResponse(HttpStatus.CREATED, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY, category);
    }

    @PutMapping
    public ResponseEntity<BaseResponse<UpdateRoomTypeMainFacilityCategoryResponse>> update(
            @RequestBody @Valid UpdateRoomTypeMainFacilityCategoryRequest request) {
        if (categoryService.getById(request.getId()) == null) {
            return sendResponse(HttpStatus.BAD_REQUEST, Messages.Error.CUSTOM_ROOM_TYPE_MAIN_FACILITY_CATEGORY_NOT_FOUND, null);
        }

        UpdateRoomTypeMainFacilityCategoryResponse category = categoryService.update(request);
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_UPDATED_SUCCESSFULLY, category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> delete(@PathVariable int id) {
        categoryService.delete(id);
        return sendResponse(HttpStatus.NO_CONTENT, Messages.Success.CUSTOM_DELETED_SUCCESSFULLY, null);
    }
}
