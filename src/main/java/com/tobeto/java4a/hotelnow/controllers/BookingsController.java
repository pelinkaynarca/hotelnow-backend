package com.tobeto.java4a.hotelnow.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.BookingService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookings.AddBookingRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookings.AddBookingResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookings.ListBookingResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/bookings")
public class BookingsController extends BaseController {

	private BookingService bookingService;

	@GetMapping("/{id}")
	public ResponseEntity<BaseResponse<ListBookingResponse>> getById(@PathVariable int id) {
		return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY,
				bookingService.getResponseById(id));
	}

	@GetMapping("/by-customer-id/{customerId}")
	public ResponseEntity<BaseResponse<List<ListBookingResponse>>> getByCustomerId(@PathVariable int customerId) {
		return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY,
				bookingService.getByCustomerId(customerId));
	}

	@GetMapping("/by-hotel-id/{hotelId}")
	public ResponseEntity<BaseResponse<List<ListBookingResponse>>> getByHotelId(@PathVariable int hotelId) {
		return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY,
				bookingService.getByHotelId(hotelId));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<BaseResponse<AddBookingResponse>> add(@RequestBody @Valid AddBookingRequest request) {
		return sendResponse(HttpStatus.CREATED, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY,
				bookingService.add(request));
	}

}
