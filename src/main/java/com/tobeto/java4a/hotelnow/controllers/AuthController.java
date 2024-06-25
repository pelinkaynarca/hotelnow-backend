package com.tobeto.java4a.hotelnow.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.java4a.hotelnow.services.abstracts.AuthService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.login.LoginRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.register.RegisterRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.login.LoginResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.register.RegisterResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody @Valid LoginRequest request) {
		return authService.login(request);
	}
	
	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public RegisterResponse register(@RequestBody @Valid RegisterRequest request) {
		return authService.register(request);
	}
}
