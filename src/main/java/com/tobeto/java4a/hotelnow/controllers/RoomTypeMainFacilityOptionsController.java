package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeMainFacilityOptionService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityoptions.ListRoomTypeMainFacilityOptionResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roomtypemainfacilityoptions")
@AllArgsConstructor
public class RoomTypeMainFacilityOptionsController {

    private RoomTypeMainFacilityOptionService roomTypeMainFacilityOptionService;

    @GetMapping("/get-all")
    public List<ListRoomTypeMainFacilityOptionResponse> getAll(){
        return roomTypeMainFacilityOptionService.getAll();

    }
}
