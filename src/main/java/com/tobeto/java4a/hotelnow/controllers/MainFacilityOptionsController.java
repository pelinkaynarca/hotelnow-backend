package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.abstracts.MainFacilityOptionService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityoptions.ListMainFacilityOptionResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mainfacilityoptions")
@AllArgsConstructor
public class MainFacilityOptionsController {

    private MainFacilityOptionService mainFacilityOptionService;

    @GetMapping("/get-all")
    public List<ListMainFacilityOptionResponse> getAll(){
        return mainFacilityOptionService.getAll();

    }
}
