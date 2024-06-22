package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeMainFacilityCategoryService;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeMainFacilityOptionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityoptions.AddRoomTypeMainFacilityOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityoptions.UpdateRoomTypeMainFacilityOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilitycategories.ListRoomTypeMainFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityoptions.AddRoomTypeMainFacilityOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityoptions.ListRoomTypeMainFacilityOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityoptions.UpdateRoomTypeMainFacilityOptionResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-type-main-facility-options")
@AllArgsConstructor
public class RoomTypeMainFacilityOptionsController  extends BaseController{

    private final RoomTypeMainFacilityOptionService roomTypeMainFacilityOptionService;
    private final RoomTypeMainFacilityCategoryService roomTypeMainFacilityCategoryService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<ListRoomTypeMainFacilityOptionResponse>>> getByCategoryId(@PathVariable int categoryId) {
        ListRoomTypeMainFacilityCategoryResponse roomTypeMainFacilityCategory = roomTypeMainFacilityCategoryService.getResponseById(categoryId);
        List<ListRoomTypeMainFacilityOptionResponse> roomTypeMainFacilityOption = roomTypeMainFacilityOptionService.getByCategoryId(categoryId);
        if (roomTypeMainFacilityCategory != null && roomTypeMainFacilityOption != null && !roomTypeMainFacilityOption.isEmpty()){
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, roomTypeMainFacilityOption);
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_TYPE_MAIN_FACILITY_OPTION_NOT_FOUND, null);
    }

    @PostMapping
    public ResponseEntity<BaseResponse<AddRoomTypeMainFacilityOptionResponse>> add(@RequestBody @Valid AddRoomTypeMainFacilityOptionRequest request){
        ListRoomTypeMainFacilityCategoryResponse roomTypeMainFacilityCategory = roomTypeMainFacilityCategoryService.getResponseById(request.getCategoryId());
        if (roomTypeMainFacilityCategory != null){
            return  sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY, roomTypeMainFacilityOptionService.add(request));
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_TYPE_MAIN_FACILITY_CATEGORY_NOT_FOUND, null);
    }

    @PutMapping
    public ResponseEntity<BaseResponse<UpdateRoomTypeMainFacilityOptionResponse>> update(
            @RequestBody @Valid UpdateRoomTypeMainFacilityOptionRequest request) {
        ListRoomTypeMainFacilityOptionResponse roomTypeMainFacilityOption = roomTypeMainFacilityOptionService.getResponseById(request.getId());
        if (roomTypeMainFacilityOption != null){
            return  sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_UPDATED_SUCCESSFULLY, roomTypeMainFacilityOptionService.update(request));
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_TYPE_MAIN_FACILITY_OPTION_NOT_FOUND, null);
    }

    @DeleteMapping
    public ResponseEntity<BaseResponse<String>> delete(@Param("id") int id){
        ListRoomTypeMainFacilityOptionResponse roomTypeMainFacilityOptionToBeFound = roomTypeMainFacilityOptionService.getResponseById(id);
        if (roomTypeMainFacilityOptionToBeFound != null) {
            roomTypeMainFacilityOptionService.delete(id);
            return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_DELETED_SUCCESSFULLY, null);
        }
        return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_ROOM_TYPE_MAIN_FACILITY_OPTION_NOT_FOUND, null);
    }

}
