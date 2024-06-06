package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.abstracts.CancellationReasonService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.cancellationreasons.ListCancellationReasonResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cancellation-reasons")
@AllArgsConstructor
public class CancellationReasonsController {

    private CancellationReasonService cancellationReasonService;

    @GetMapping("/get-all")
    public List<ListCancellationReasonResponse> getAll() {
        return cancellationReasonService.getAll();
    }


}
