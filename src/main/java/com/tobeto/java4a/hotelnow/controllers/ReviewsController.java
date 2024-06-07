package com.tobeto.java4a.hotelnow.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.java4a.hotelnow.services.abstracts.ReviewService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviews.AddReviewRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviews.UpdateReviewRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.AddReviewResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.ListReviewResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.UpdateReviewResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/reviews")
@AllArgsConstructor
public class ReviewsController {
	
	private ReviewService reviewService;
	
	@GetMapping("/{id}")
	public ListReviewResponse getById(@PathVariable int id) {
		return reviewService.getById(id);
	}
	
	@GetMapping("/by-booking-id/{bookingId}")
	public ListReviewResponse getByBookingId(@PathVariable int bookingId) {
		return reviewService.getByBookingId(bookingId);
	}
	
	@GetMapping("/by-hotel-id/{hotelId}")
	public List<ListReviewResponse> getByHotelId(@PathVariable int hotelId) {
		return reviewService.getByHotelId(hotelId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AddReviewResponse add(@RequestBody @Valid AddReviewRequest request) {
		return reviewService.add(request);
	}
	
	@PutMapping
	public UpdateReviewResponse update(@RequestBody @Valid UpdateReviewRequest request) {
		return reviewService.update(request);
	}

}
