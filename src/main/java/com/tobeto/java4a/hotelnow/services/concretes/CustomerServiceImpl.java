package com.tobeto.java4a.hotelnow.services.concretes;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.tobeto.java4a.hotelnow.entities.concretes.Customer;
import com.tobeto.java4a.hotelnow.entities.concretes.Role;
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
	private final PasswordEncoder passwordEncoder;

	@Override
	public Customer getById(int id) {
		return customerRepository.findById(id).orElse(null);
	}

	@Override
	public ListCustomerResponse getResponseById(int id) {
		Customer customer = customerRepository.findById(id).orElse(null);
		return CustomerMapper.INSTANCE.listResponseFromCustomer(customer);
	}

	@Override
	public AddCustomerResponse add(AddCustomerRequest request) {
		Customer customer = CustomerMapper.INSTANCE.customerFromAddRequest(request);
		customer.setRole(Role.CUSTOMER);
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		Customer savedCustomer = addCustomer(customer);
		return CustomerMapper.INSTANCE.addResponseFromCustomer(savedCustomer);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public UpdateCustomerResponse update(UpdateCustomerRequest request) {
		// TODO Customer bilgisi güncelleme işlemi
		Customer customer = CustomerMapper.INSTANCE.customerFromUpdateRequest(request);
		customer.setRole(Role.CUSTOMER);
		customer.setPassword(passwordEncoder.encode(request.getPassword()));
		Customer savedCustomer = customerRepository.save(customer);
		return CustomerMapper.INSTANCE.updateResponseFromCustomer(savedCustomer);
	}

	@Override
	public void deleteById(int id) {
		customerRepository.deleteById(id);
	}

	@Override
	public Customer getLoggedInCustomer() {
		int idOfLoggedInCustomer = (int) SecurityContextHolder.getContext().getAuthentication().getCredentials();
		return getById(idOfLoggedInCustomer);
	}
}
