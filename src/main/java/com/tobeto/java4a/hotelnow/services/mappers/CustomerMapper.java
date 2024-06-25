package com.tobeto.java4a.hotelnow.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.Customer;
import com.tobeto.java4a.hotelnow.entities.concretes.Role;
import com.tobeto.java4a.hotelnow.services.dtos.requests.customers.AddCustomerRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.customers.UpdateCustomerRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.register.RegisterRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.customers.AddCustomerResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.customers.ListCustomerResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.customers.UpdateCustomerResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.register.RegisterResponse;

@Mapper
public interface CustomerMapper {

	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
	
	@Mapping(target = "countryName", source = "country.name")
	@Mapping(target = "nationalityId", source = "country.id")
	ListCustomerResponse listResponseFromCustomer(Customer customer);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "role", ignore = true)
	@Mapping(target = "reviews", ignore = true)
	@Mapping(target = "bookings", ignore = true)
	@Mapping(target = "authorities", ignore = true)
	@Mapping(target = "country.id", source = "nationalityId")
	Customer customerFromAddRequest(AddCustomerRequest request);
	
	@Mapping(target = "nationalityId", source = "country.id")
	AddCustomerResponse addResponseFromCustomer(Customer customer);
	
	@Mapping(target = "nationalityId", source = "country.id")
	UpdateCustomerResponse updateResponseFromCustomer(Customer customer);
	
	@Mapping(target = "role", ignore = true)
	@Mapping(target = "reviews", ignore = true)
	@Mapping(target = "authorities", ignore = true)
	@Mapping(target = "bookings", ignore = true)
	@Mapping(target = "country.id", source = "nationalityId")
	Customer customerFromUpdateRequest(UpdateCustomerRequest request);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "role", expression="java( getCustomerRole() )")
	@Mapping(target = "reviews", ignore = true)
	@Mapping(target = "bookings", ignore = true)
	@Mapping(target = "authorities", ignore = true)
	@Mapping(target = "country.id", source = "nationalityId")
	Customer customerFromRegisterRequest(RegisterRequest request);

	RegisterResponse registerResponseFromCustomer(Customer savedUser);

	default Role getCustomerRole() {
		return Role.CUSTOMER;
	}
}
