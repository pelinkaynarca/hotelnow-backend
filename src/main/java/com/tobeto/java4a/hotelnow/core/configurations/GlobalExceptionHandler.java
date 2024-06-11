package com.tobeto.java4a.hotelnow.core.configurations;

import com.tobeto.java4a.hotelnow.controllers.BaseController;
import com.tobeto.java4a.hotelnow.core.utils.exceptions.problemdetails.AuthorizationProblemDetails;
import com.tobeto.java4a.hotelnow.core.utils.exceptions.problemdetails.BusinessProblemDetails;
import com.tobeto.java4a.hotelnow.core.utils.exceptions.problemdetails.ValidationProblemDetails;
import com.tobeto.java4a.hotelnow.core.utils.exceptions.types.AuthorizationException;
import com.tobeto.java4a.hotelnow.core.utils.exceptions.types.BusinessException;
import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler extends BaseController {

	@ExceptionHandler({ BusinessException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<BaseResponse<BusinessProblemDetails>> handleRuntimeException(BusinessException exception) {
		return sendResponse(HttpStatus.BAD_REQUEST.value(), Messages.Error.CUSTOM_BAD_REQUEST,
				new BusinessProblemDetails(exception.getMessage()));
	}

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<BaseResponse<ValidationProblemDetails>> handleValidationException(
			MethodArgumentNotValidException exception) {
		List<String> errorMessages = new ArrayList<>();
		List<FieldError> errors = exception.getBindingResult().getFieldErrors();
		for (FieldError error : errors) {
			errorMessages.add(error.getDefaultMessage());
		}
		return sendResponse(HttpStatus.BAD_REQUEST.value(), Messages.Error.CUSTOM_BAD_REQUEST,
				new ValidationProblemDetails(errorMessages));
	}
	
	@ExceptionHandler({ AuthorizationException.class })
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ResponseEntity<BaseResponse<AuthorizationProblemDetails>> handleAuthorizationException(
			AuthorizationException exception) {
		return sendResponse(HttpStatus.FORBIDDEN.value(), Messages.Error.AUTHORIZATION_VIOLATION,
				new AuthorizationProblemDetails(exception.getMessage()));
	}
}
