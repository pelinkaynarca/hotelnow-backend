package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.CancellationReasonService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.cancellationreasons.AddCancellationReasonRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.cancellationreasons.AddCancellationReasonResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.cancellationreasons.ListCancellationReasonResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cancellation-reasons")
@AllArgsConstructor
public class CancellationReasonsController extends BaseController {

    private CancellationReasonService cancellationReasonService;

    @GetMapping("/get-all")
    public ResponseEntity<BaseResponse<List<ListCancellationReasonResponse>>> getAll() {
        return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, cancellationReasonService.getAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BaseResponse<AddCancellationReasonResponse>> add(@RequestBody @Valid AddCancellationReasonRequest request) {
        AddCancellationReasonResponse addCancellationReasonResponse = cancellationReasonService.add(request);
        return sendResponse(HttpStatus.CREATED, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY, addCancellationReasonResponse);
    }
}
