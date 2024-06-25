package com.tobeto.java4a.hotelnow.services.dtos.responses.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
	private String firstName;
	private String lastName;
	private String email;
	private String token;
}
