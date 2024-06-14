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
import com.tobeto.java4a.hotelnow.services.abstracts.BookingHistoryService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookinghistories.AddBookingHistoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookinghistories.AddBookingHistoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookinghistories.ListBookingHistoryResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/booking-histories")
public class BookingHistoriesController extends BaseController {

	private BookingHistoryService bookingHistoryService;

	@GetMapping("/by-booking-id/{bookingId}")
	public ResponseEntity<BaseResponse<List<ListBookingHistoryResponse>>> getByBookingId(@PathVariable int bookingId) {
		List<ListBookingHistoryResponse> bookingHistoryResponses = bookingHistoryService
				.getResponsesByBookingId(bookingId);
		if (bookingHistoryResponses == null || bookingHistoryResponses.size() == 0) {
			return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_BOOKING_HISTORY_NOT_FOUND, null);
		} else {
			return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, bookingHistoryResponses);
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<BaseResponse<AddBookingHistoryResponse>> add(
			@RequestBody @Valid AddBookingHistoryRequest request) {
		AddBookingHistoryResponse addBookingHistoryResponse = bookingHistoryService.add(request);
		return sendResponse(HttpStatus.CREATED, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY, addBookingHistoryResponse);
	}

}
