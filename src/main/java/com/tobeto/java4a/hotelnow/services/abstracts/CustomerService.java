package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.entities.concretes.Customer;
import com.tobeto.java4a.hotelnow.services.dtos.requests.customers.AddCustomerRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.customers.UpdateCustomerRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.customers.AddCustomerResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.customers.ListCustomerResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.customers.UpdateCustomerResponse;

public interface CustomerService {
	
	Customer getById(int id);
	
	ListCustomerResponse getResponseById(int id);
	
	AddCustomerResponse add(AddCustomerRequest request);
	
	UpdateCustomerResponse update(UpdateCustomerRequest request);
	
	void delete(int id);

}
