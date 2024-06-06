package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeFacilityCategoryService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitycategories.ListRoomTypeFacilityCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roomtypefacilitycategories")
@AllArgsConstructor
public class RoomTypeFacilityCategoriesController {

    private RoomTypeFacilityCategoryService roomTypeFacilityCategoryService;

    @GetMapping("/get-all")
    public List<ListRoomTypeFacilityCategoryResponse> getAll(){
        return roomTypeFacilityCategoryService.getAll();

    }
}
