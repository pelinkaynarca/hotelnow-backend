package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeFacilityDetailSelectionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailselections.AddRoomTypeFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailselections.UpdateRoomTypeFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.AddRoomTypeFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.ListRoomTypeFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.UpdateRoomTypeFacilityDetailSelectionResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-type-facility-detail-selections")
@AllArgsConstructor
public class RoomTypeFacilityDetailSelectionsController {

    private RoomTypeFacilityDetailSelectionService roomTypeFacilityDetailSelectionService;

    @GetMapping("/get-all")
    public List<ListRoomTypeFacilityDetailSelectionResponse> getAll() {
        return roomTypeFacilityDetailSelectionService.getAll();
    }

    @GetMapping("/{id}")
    public ListRoomTypeFacilityDetailSelectionResponse getById(@PathVariable int id) {
        return roomTypeFacilityDetailSelectionService.getById(id);
    }

    @PostMapping("/create-facility-detail")
    @ResponseStatus(HttpStatus.CREATED)
    public AddRoomTypeFacilityDetailSelectionResponse add(@RequestBody @Valid AddRoomTypeFacilityDetailSelectionRequest request) {
        return roomTypeFacilityDetailSelectionService.add(request);
    }

    @PutMapping("/update-facility-detail")
    public UpdateRoomTypeFacilityDetailSelectionResponse update(@RequestBody @Valid UpdateRoomTypeFacilityDetailSelectionRequest request) {
        return roomTypeFacilityDetailSelectionService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        roomTypeFacilityDetailSelectionService.delete(id);
    }
}
