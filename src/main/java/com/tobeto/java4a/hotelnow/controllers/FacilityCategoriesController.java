package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.abstracts.FacilityCategoryService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitycategories.ListFacilityCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/facilitycategories")
@AllArgsConstructor
public class FacilityCategoriesController {

    private FacilityCategoryService facilityCategoryService;

    @GetMapping("/get-all")
    public List<ListFacilityCategoryResponse> getAll(){
        return facilityCategoryService.getAll();
    }
}
