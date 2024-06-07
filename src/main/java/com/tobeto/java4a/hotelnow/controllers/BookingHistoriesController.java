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

import com.tobeto.java4a.hotelnow.services.abstracts.BookingHistoryService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookinghistories.AddBookingHistoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookinghistories.AddBookingHistoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookinghistories.ListBookingHistoryResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/booking-histories")
public class BookingHistoriesController {
	
	private BookingHistoryService bookingHistoryService;
	
	@GetMapping("/by-booking-id/{bookingId}")
	public List<ListBookingHistoryResponse> getByBookingId(@PathVariable int bookingId) {
		return bookingHistoryService.getByBookingId(bookingId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AddBookingHistoryResponse add(@RequestBody @Valid AddBookingHistoryRequest request) {
		return bookingHistoryService.add(request);
	}
	
}
