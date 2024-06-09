package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.dtos.responses.responsemodels.ResponseModel;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypes.AddRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypes.UpdateRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.AddRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.ListRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.UpdateRoomTypeResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-types")
@AllArgsConstructor
public class RoomTypesController extends BaseController {

    private RoomTypeService roomTypeService;

    @GetMapping("/get-all")
    public ResponseEntity<ResponseModel<List<ListRoomTypeResponse>>> getAll() {
        List<ListRoomTypeResponse> roomTypes = roomTypeService.getAll();
            return OK(roomTypes);
    }

    @GetMapping("/hotel/{hotelId}")
    public List<ListRoomTypeResponse> getByHotelId(@PathVariable("hotelId") int hotelId){
        return roomTypeService.getByHotelId(hotelId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseModel<ListRoomTypeResponse>> getById(@PathVariable int id) {
        ListRoomTypeResponse roomType = roomTypeService.getById(id);
        return roomType == null ? NOT_FOUND() : OK(roomType);
    }

    @PostMapping("/create-room-type")
    @ResponseStatus(HttpStatus.CREATED)
    public AddRoomTypeResponse add(@RequestBody @Valid AddRoomTypeRequest request) {
        return roomTypeService.add(request);
    }

    @PutMapping("/update-room-type")
    public UpdateRoomTypeResponse update(@RequestBody @Valid UpdateRoomTypeRequest request) {
        return roomTypeService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        roomTypeService.delete(id);
    }
}
