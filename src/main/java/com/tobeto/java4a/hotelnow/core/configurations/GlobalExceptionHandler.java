package com.tobeto.java4a.hotelnow.core.configurations;

import com.tobeto.java4a.hotelnow.core.utils.exceptions.problemdetails.BusinessProblemDetails;
import com.tobeto.java4a.hotelnow.core.utils.exceptions.problemdetails.ValidationProblemDetails;
import com.tobeto.java4a.hotelnow.core.utils.exceptions.types.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleRuntimeException(BusinessException exception) {
        return new BusinessProblemDetails(exception.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException exception) {
        List<String> errorMessages = new ArrayList<>();
        List<FieldError> errors = exception.getBindingResult().getFieldErrors();
        for(FieldError error: errors) {
            errorMessages.add(error.getDefaultMessage());
        }
        return new ValidationProblemDetails(errorMessages);
    }
}
