package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeMainFacilitySelectionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityselections.AddRoomTypeMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityselections.UpdateRoomTypeMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.AddRoomTypeMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.ListRoomTypeMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.RoomTypeMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.UpdateRoomTypeMainFacilitySelectionResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-type-main-facility-selections")
@AllArgsConstructor
public class RoomTypeMainFacilitySelectionsController {

    private RoomTypeMainFacilitySelectionService roomTypeMainFacilitySelectionService;

    @GetMapping("/room-types/{roomTypeId}")
    public List<ListRoomTypeMainFacilitySelectionResponse> getByRoomTypeId(@PathVariable("roomTypeId") int roomTypeId) {
        return roomTypeMainFacilitySelectionService.getByRoomTypeId(roomTypeId);
    }

    @GetMapping("/{id}")
    public RoomTypeMainFacilitySelectionResponse getById(@PathVariable int id) {
        return roomTypeMainFacilitySelectionService.getById(id);
    }

    @PostMapping("/create-main-facility")
    @ResponseStatus(HttpStatus.CREATED)
    public AddRoomTypeMainFacilitySelectionResponse add(@RequestBody @Valid AddRoomTypeMainFacilitySelectionRequest request) {
        return roomTypeMainFacilitySelectionService.add(request);
    }

    @PutMapping("/update-main-facility")
    public UpdateRoomTypeMainFacilitySelectionResponse update(@RequestBody @Valid UpdateRoomTypeMainFacilitySelectionRequest request) {
        return roomTypeMainFacilitySelectionService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        roomTypeMainFacilitySelectionService.delete(id);
    }
}
