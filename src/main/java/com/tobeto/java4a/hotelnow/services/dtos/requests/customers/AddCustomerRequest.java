package com.tobeto.java4a.hotelnow.services.dtos.requests.customers;

import com.tobeto.java4a.hotelnow.services.dtos.requests.users.AddUserRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest extends AddUserRequest{
	
	private int nationalityId;
	
}
