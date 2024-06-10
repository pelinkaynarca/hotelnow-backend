package com.tobeto.java4a.hotelnow.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.java4a.hotelnow.services.abstracts.CustomerService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.customers.AddCustomerRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.customers.UpdateCustomerRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.customers.AddCustomerResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.customers.ListCustomerResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.customers.UpdateCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomersController {
	
	private CustomerService customerService;
	
	@GetMapping("/{id}")
	public ListCustomerResponse getById(@PathVariable int id) {
		return customerService.getResponseById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AddCustomerResponse add(@RequestBody @Valid AddCustomerRequest request) {
		return customerService.add(request);
	}
	
	@PutMapping
	public UpdateCustomerResponse update(@RequestBody @Valid UpdateCustomerRequest request) {
		return customerService.update(request);
	}
	
	@DeleteMapping
	public void delete(@PathVariable int id) {
		customerService.delete(id);
	}

}
