package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.requests.login.LoginRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.login.LoginResponse;

public interface AuthService {
	LoginResponse login(LoginRequest request);
}
