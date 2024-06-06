package com.tobeto.java4a.hotelnow.services.concretes;

import org.springframework.stereotype.Service;

import com.tobeto.java4a.hotelnow.repositories.CustomerRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.CustomerService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.customers.AddCustomerRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.customers.UpdateCustomerRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.customers.AddCustomerResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.customers.ListCustomerResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.customers.UpdateCustomerResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService{
	
	private CustomerRepository customerRepository;

	@Override
	public ListCustomerResponse getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddCustomerResponse add(AddCustomerRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateCustomerResponse update(UpdateCustomerRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
