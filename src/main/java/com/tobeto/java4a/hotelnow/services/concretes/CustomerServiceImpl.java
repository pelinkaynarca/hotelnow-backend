package com.tobeto.java4a.hotelnow.services.concretes;

import org.springframework.stereotype.Service;

import com.tobeto.java4a.hotelnow.entities.concretes.Customer;
import com.tobeto.java4a.hotelnow.repositories.CustomerRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.CustomerService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.customers.AddCustomerRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.customers.UpdateCustomerRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.customers.AddCustomerResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.customers.ListCustomerResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.customers.UpdateCustomerResponse;
import com.tobeto.java4a.hotelnow.services.mappers.CustomerMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	@Override
	public Customer getById(int id) {
		return customerRepository.findById(id).orElseThrow();
	}

	@Override
	public ListCustomerResponse getResponseById(int id) {
		Customer customer = customerRepository.findById(id).orElseThrow();
		return CustomerMapper.INSTANCE.listResponseFromCustomer(customer);
	}

	@Override
	public AddCustomerResponse add(AddCustomerRequest request) {
		Customer customer = CustomerMapper.INSTANCE.customerFromAddRequest(request);
		Customer savedCustomer = customerRepository.save(customer);
		return CustomerMapper.INSTANCE.addResponseFromCustomer(savedCustomer);
	}

	@Override
	public UpdateCustomerResponse update(UpdateCustomerRequest request) {
		Customer customer = CustomerMapper.INSTANCE.customerFromUpdateRequest(request);
		Customer savedCustomer = customerRepository.save(customer);
		return CustomerMapper.INSTANCE.updateResponseFromCustomer(savedCustomer);
	}

	@Override
	public void delete(int id) {
		customerRepository.deleteById(id);
	}
}
