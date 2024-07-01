package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.entities.concretes.MainFacilityOption;
import com.tobeto.java4a.hotelnow.services.abstracts.MainFacilityOptionService;
import com.tobeto.java4a.hotelnow.services.abstracts.MainFacilitySelectionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityselections.AddMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.AddMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.ListMainFacilitySelectionResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/main-facility-selections")
@AllArgsConstructor
public class MainFacilitySelectionsController extends BaseController {

    private final MainFacilitySelectionService mainFacilitySelectionService;
    private final MainFacilityOptionService mainFacilityOptionService;

    @GetMapping("/by-hotel-id/{hotelId}")
    public ResponseEntity<BaseResponse<List<ListMainFacilitySelectionResponse>>> getByHotelId(@PathVariable int hotelId) {
        List<ListMainFacilitySelectionResponse> mainFacilitySelectionsToBeFound = mainFacilitySelectionService.getByHotelId(hotelId);
        if (mainFacilitySelectionsToBeFound != null && !mainFacilitySelectionsToBeFound.isEmpty()) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, mainFacilitySelectionsToBeFound);
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_MAIN_FACILITY_SELECTION_NOT_FOUND, null);
    }

    @GetMapping("/for-staff")
    public ResponseEntity<BaseResponse<List<ListMainFacilitySelectionResponse>>> getByHotelIdForStaff() {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, mainFacilitySelectionService.getByHotelIdForStaff());
        }


    @GetMapping("/by-hotel/{hotelId}/display/{display}")
    public ResponseEntity<BaseResponse<List<ListMainFacilitySelectionResponse>>> getByHotelIdAndDisplay(@PathVariable int hotelId, boolean display) {
        List<ListMainFacilitySelectionResponse> mainFacilitySelectionsToBeFound = mainFacilitySelectionService.getByHotelIdAndDisplay(hotelId, display);
        if (mainFacilitySelectionsToBeFound != null && !mainFacilitySelectionsToBeFound.isEmpty()) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, mainFacilitySelectionsToBeFound);
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_MAIN_FACILITY_SELECTION_NOT_FOUND, null);
    }

    @GetMapping("/random-by-hotel/{hotelId}")
    public ResponseEntity<BaseResponse<List<ListMainFacilitySelectionResponse>>> getRandomByHotelId(@PathVariable int hotelId) {
        List<ListMainFacilitySelectionResponse> mainFacilitySelectionsToBeFound = mainFacilitySelectionService.getRandomByHotelId(hotelId);
        if (mainFacilitySelectionsToBeFound != null && !mainFacilitySelectionsToBeFound.isEmpty()) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, mainFacilitySelectionsToBeFound);
        }
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, new ArrayList<>());
    }

    @PostMapping
    public ResponseEntity<BaseResponse<AddMainFacilitySelectionResponse>> add(@RequestBody @Valid AddMainFacilitySelectionRequest request) {
        MainFacilityOption mainFacilityOption = mainFacilityOptionService.getById(request.getOptionId());
        if (mainFacilityOption != null) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY, mainFacilitySelectionService.add(request));
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_MAIN_FACILITY_OPTION_NOT_FOUND, null);
    }


    /* @PutMapping
    public ResponseEntity<BaseResponse<UpdateMainFacilitySelectionResponse>> update(@RequestBody @Valid UpdateMainFacilitySelectionRequest request) {
        ListMainFacilitySelectionResponse mainFacilitySelectionToBeFound = mainFacilitySelectionService.getResponseById(request.getId());
        if ( mainFacilitySelectionToBeFound != null) {
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_UPDATED_SUCCESSFULLY, mainFacilitySelectionService.update(request));
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_MAIN_FACILITY_SELECTION_NOT_FOUND, null);
    } */

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<String>> delete(@PathVariable int id) {
            mainFacilitySelectionService.deleteById(id);
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_DELETED_SUCCESSFULLY, null);
        }

}
