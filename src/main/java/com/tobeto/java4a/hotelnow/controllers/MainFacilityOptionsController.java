package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.MainFacilityOptionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityoptions.AddMainFacilityOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityoptions.UpdateMainFacilityOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityoptions.AddMainFacilityOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityoptions.ListMainFacilityOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityoptions.UpdateMainFacilityOptionResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/main-facility-options")
@AllArgsConstructor
public class MainFacilityOptionsController extends BaseController {

    private MainFacilityOptionService mainFacilityOptionService;

    @GetMapping("/get-all")
    public ResponseEntity<BaseResponse<List<ListMainFacilityOptionResponse>>> getAll() {
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, mainFacilityOptionService.getAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BaseResponse<AddMainFacilityOptionResponse>> add(
            @RequestBody @Valid AddMainFacilityOptionRequest request) {
        AddMainFacilityOptionResponse addMainFacilityOptionResponse = mainFacilityOptionService
                .add(request);
        return sendResponse(HttpStatus.CREATED, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY,
                addMainFacilityOptionResponse);
    }

    @PutMapping
    public ResponseEntity<BaseResponse<UpdateMainFacilityOptionResponse>> update(
            @RequestBody @Valid UpdateMainFacilityOptionRequest request) {
        UpdateMainFacilityOptionResponse updateMainFacilityOptionResponse = mainFacilityOptionService
                .update(request);
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_UPDATED_SUCCESSFULLY,
                updateMainFacilityOptionResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<String>> delete(@PathVariable int id) {
        mainFacilityOptionService.deleteById(id);
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_DELETED_SUCCESSFULLY, null);
    }
}
