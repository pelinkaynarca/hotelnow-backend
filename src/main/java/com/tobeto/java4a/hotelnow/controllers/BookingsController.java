package com.tobeto.java4a.hotelnow.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.java4a.hotelnow.services.abstracts.BookingService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookings.AddBookingRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookings.AddBookingResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookings.ListBookingResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/bookings")
@AllArgsConstructor
public class BookingsController {

	private BookingService bookingService;

	@GetMapping("/{id}")
	public ListBookingResponse getById(@PathVariable int id) {
		return bookingService.getById(id);
	}

	@GetMapping("/by-customer-id/{customerId}")
	public List<ListBookingResponse> getByCustomerId(@PathVariable int customerId) {
		return bookingService.getByCustomerId(customerId);
	}

	@GetMapping("/by-hotel-id/{hotelId}")
	public List<ListBookingResponse> getByHotelId(@PathVariable int hotelId) {
		return bookingService.getByHotelId(hotelId);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AddBookingResponse add(@RequestBody @Valid AddBookingRequest request) {
		return bookingService.add(request);
	}

}
