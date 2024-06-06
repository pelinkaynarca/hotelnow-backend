package com.tobeto.java4a.hotelnow.services.dtos.responses.customers;

import com.tobeto.java4a.hotelnow.services.dtos.responses.users.AddUserResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerResponse extends AddUserResponse{
	
	private int nationalityId;

}
