package com.tobeto.java4a.hotelnow.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.AuthService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.login.LoginRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.register.RegisterRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.login.LoginResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.register.RegisterResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController extends BaseController {

	private final AuthService authService;

	@PostMapping("/login")
	public ResponseEntity<BaseResponse<LoginResponse>> login(@RequestBody @Valid LoginRequest request) {
		LoginResponse loginResponse = authService.login(request);
		return sendResponse(HttpStatus.OK, null, loginResponse);
	}

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<BaseResponse<RegisterResponse>> register(@RequestBody @Valid RegisterRequest request) {
		RegisterResponse registerResponse = authService.register(request);
		return sendResponse(HttpStatus.CREATED, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY, registerResponse);
	}
}
