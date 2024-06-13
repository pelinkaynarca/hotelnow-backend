package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeFacilityCategoryService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitycategories.AddRoomTypeFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitycategories.UpdateRoomTypeFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitycategories.AddRoomTypeFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitycategories.ListRoomTypeFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitycategories.UpdateRoomTypeFacilityCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-type-facility-categories")
@AllArgsConstructor
public class RoomTypeFacilityCategoriesController {

    private RoomTypeFacilityCategoryService roomTypeFacilityCategoryService;

    @GetMapping("/get-all")
    public List<ListRoomTypeFacilityCategoryResponse> getAll(){
        return roomTypeFacilityCategoryService.getAll();
    }

    @PostMapping
    public AddRoomTypeFacilityCategoryResponse add(@RequestBody AddRoomTypeFacilityCategoryRequest request){
        return roomTypeFacilityCategoryService.add(request);
    }

    @PutMapping
    public UpdateRoomTypeFacilityCategoryResponse update(@RequestBody UpdateRoomTypeFacilityCategoryRequest request){
        return roomTypeFacilityCategoryService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){ roomTypeFacilityCategoryService.delete(id);}
}
