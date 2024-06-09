package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BaseController {

    protected<T> ResponseEntity<BaseResponse<T>> sendResponse(int statusCode, String statusMessage, T result) {
        BaseResponse<T> responseModels = new BaseResponse<>();
        responseModels.setStatusCode(statusCode);
        responseModels.setStatusMessage(statusMessage);
        responseModels.setResult(result);

        return ResponseEntity.status(statusCode).body(responseModels);
    }
}
