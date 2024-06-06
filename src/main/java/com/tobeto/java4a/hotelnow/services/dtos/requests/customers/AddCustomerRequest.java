package com.tobeto.java4a.hotelnow.services.dtos.requests.customers;

import com.tobeto.java4a.hotelnow.services.dtos.requests.users.AddUserRequest;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest extends AddUserRequest{
	
	@Min(value = 1)
	private int nationalityId;
	
}
