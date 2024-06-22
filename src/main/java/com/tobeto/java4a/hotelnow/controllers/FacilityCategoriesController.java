package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.FacilityCategoryService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitycategories.AddFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitycategories.UpdateFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitycategories.AddFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitycategories.ListFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitycategories.UpdateFacilityCategoryResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facility-categories")
@AllArgsConstructor
public class FacilityCategoriesController extends BaseController {

    private FacilityCategoryService facilityCategoryService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<ListFacilityCategoryResponse>>> getAll() {
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, facilityCategoryService.getAll());
    }


    @PostMapping
    public ResponseEntity<BaseResponse<AddFacilityCategoryResponse>> add(
            @RequestBody @Valid AddFacilityCategoryRequest request) {
        AddFacilityCategoryResponse addFacilityCategoryResponse = facilityCategoryService
                .add(request);
        return sendResponse(HttpStatus.CREATED, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY,
                addFacilityCategoryResponse);
    }

    @PutMapping
    public ResponseEntity<BaseResponse<UpdateFacilityCategoryResponse>> update(
            @RequestBody @Valid UpdateFacilityCategoryRequest request) {
        UpdateFacilityCategoryResponse updateFacilityCategoryResponse = facilityCategoryService
                .update(request);
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_UPDATED_SUCCESSFULLY,
                updateFacilityCategoryResponse);
    }

    @DeleteMapping
    public ResponseEntity<BaseResponse<String>> delete(@PathVariable int id) {
        facilityCategoryService.deleteById(id);
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_DELETED_SUCCESSFULLY, null);
    }

}
