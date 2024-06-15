package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.FacilityCategoryService;
import com.tobeto.java4a.hotelnow.services.abstracts.FacilityDetailOptionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailoptions.AddFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailoptions.UpdateFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitycategories.ListFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailoptions.AddFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailoptions.ListFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailoptions.UpdateFacilityDetailOptionResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facility-detail-options")
@AllArgsConstructor
public class FacilityDetailOptionsController extends BaseController {

    private final FacilityDetailOptionService facilityDetailOptionService;
    private final FacilityCategoryService facilityCategoryService;

    @GetMapping("/by-category-id/{categoryId}")
    public ResponseEntity<BaseResponse<List<ListFacilityDetailOptionResponse>>> getByCategoryId(@PathVariable int categoryId) {
        ListFacilityCategoryResponse facilityCategory = facilityCategoryService.getResponseById(categoryId);
        List<ListFacilityDetailOptionResponse> facilityDetailOptions = facilityDetailOptionService.getByCategoryId(categoryId);
        if (facilityCategory != null && facilityDetailOptions != null && !facilityDetailOptions.isEmpty()) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, facilityDetailOptionService.getByCategoryId(categoryId));
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_FACILITY_DETAIL_OPTION_NOT_FOUND, null);
    }

    @PostMapping
    public ResponseEntity<BaseResponse<AddFacilityDetailOptionResponse>> add(@RequestBody @Valid AddFacilityDetailOptionRequest request) {
        ListFacilityCategoryResponse facilityCategory = facilityCategoryService.getResponseById(request.getCategoryId());
        if (facilityCategory != null) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY, facilityDetailOptionService.add(request));
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_FACILITY_CATEGORY_NOT_FOUND, null);
    }

    @PutMapping
    public ResponseEntity<BaseResponse<UpdateFacilityDetailOptionResponse>> update(@RequestBody @Valid UpdateFacilityDetailOptionRequest request) {
        ListFacilityDetailOptionResponse facilityDetailOptionToBeFound = facilityDetailOptionService.getById(request.getId());
        if (facilityDetailOptionToBeFound != null) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_UPDATED_SUCCESSFULLY, facilityDetailOptionService.update(request));
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_FACILITY_DETAIL_OPTION_NOT_FOUND, null);
    }

    @DeleteMapping
    public ResponseEntity<BaseResponse<String>> delete(@Param("id") int id) {
        ListFacilityDetailOptionResponse facilityDetailOptionToBeFound = facilityDetailOptionService.getById(id);
        if (facilityDetailOptionToBeFound != null) {
            facilityDetailOptionService.delete(id);
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_DELETED_SUCCESSFULLY, null);
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_FACILITY_DETAIL_OPTION_NOT_FOUND, null);
    }

}
