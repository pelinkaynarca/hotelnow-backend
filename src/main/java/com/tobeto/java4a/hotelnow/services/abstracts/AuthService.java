package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.requests.login.LoginRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.register.RegisterRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.login.LoginResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.register.RegisterResponse;

public interface AuthService {
	
	LoginResponse login(LoginRequest request);

	RegisterResponse register(RegisterRequest request);
}
