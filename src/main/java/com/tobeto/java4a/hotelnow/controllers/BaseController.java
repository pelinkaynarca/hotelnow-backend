package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.dtos.responses.responsemodels.ResponseModel;
import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    protected <T> ResponseEntity<ResponseModel<T>> OK(T result) {
        ResponseModel<T> responseModel = new ResponseModel<>();
        responseModel.setStatusCode(200);
        responseModel.setStatusMessage(Messages.Success.SUCCESSFULLY_LISTED);
        responseModel.setResult(result);

        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }
    protected <T> ResponseEntity<ResponseModel<T>> NOT_FOUND() {
        ResponseModel<T> responseModel = new ResponseModel<>();
        responseModel.setStatusCode(404);
        responseModel.setStatusMessage(Messages.Error.NOT_FOUND);
        responseModel.setResult(null);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseModel);
    }
}
