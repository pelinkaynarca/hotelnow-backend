package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeFacilityDetailOptionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailoptions.AddRoomTypeFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailoptions.UpdateRoomTypeFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailoptions.AddRoomTypeFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailoptions.ListRoomTypeFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailoptions.UpdateRoomTypeFacilityDetailOptionResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-type-facility-detail-options")
@AllArgsConstructor
public class RoomTypeFacilityDetailOptionsController {

    private RoomTypeFacilityDetailOptionService roomTypeFacilityDetailOptionService;

    @GetMapping("/by-category-id/{categoryId}")
    public List<ListRoomTypeFacilityDetailOptionResponse> getByCategoryId(@PathVariable int categoryId) {
        return roomTypeFacilityDetailOptionService.getByCategoryId(categoryId);
    }

    @PostMapping
    public AddRoomTypeFacilityDetailOptionResponse add(@RequestBody AddRoomTypeFacilityDetailOptionRequest request) {
        return roomTypeFacilityDetailOptionService.add(request);
    }

    @PutMapping
    public UpdateRoomTypeFacilityDetailOptionResponse update(@RequestBody UpdateRoomTypeFacilityDetailOptionRequest request) {
        return roomTypeFacilityDetailOptionService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        roomTypeFacilityDetailOptionService.delete(id);
    }

}
