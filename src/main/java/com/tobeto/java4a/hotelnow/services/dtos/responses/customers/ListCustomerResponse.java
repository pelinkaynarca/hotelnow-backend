package com.tobeto.java4a.hotelnow.services.dtos.responses.customers;

import com.tobeto.java4a.hotelnow.services.dtos.responses.users.ListUserResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListCustomerResponse extends ListUserResponse {
	
	private String countryId;
	
	private String countryName;

}
