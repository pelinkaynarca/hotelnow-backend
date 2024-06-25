package com.tobeto.java4a.hotelnow.services.dtos.responses.register;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;

}
