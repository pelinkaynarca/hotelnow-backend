package com.tobeto.java4a.hotelnow.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.ReviewService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviews.AddReviewRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviews.UpdateReviewRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.AddReviewResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.ListReviewResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.UpdateReviewResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/reviews")
@AllArgsConstructor
public class ReviewsController extends BaseController {

	private ReviewService reviewService;

	@GetMapping("/{id}")
	public ResponseEntity<BaseResponse<ListReviewResponse>> getById(@PathVariable int id) {
		ListReviewResponse listReviewResponse = reviewService.getById(id);
		if (listReviewResponse == null) {
			return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_REVIEW_NOT_FOUND, null);
		} else {
			return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, listReviewResponse);
		}
	}

	@GetMapping("/by-booking-id/{bookingId}")
	public ResponseEntity<BaseResponse<ListReviewResponse>> getByBookingId(@PathVariable int bookingId) {
		ListReviewResponse listReviewResponse = reviewService.getById(bookingId);
		if (listReviewResponse == null) {
			return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_REVIEW_NOT_FOUND, null);
		} else {
			return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, listReviewResponse);
		}
	}

	@GetMapping("/by-hotel-id/{hotelId}")
	public ResponseEntity<BaseResponse<List<ListReviewResponse>>> getByHotelId(@PathVariable int hotelId) {
		List<ListReviewResponse> listReviewResponses = reviewService.getByHotelId(hotelId);
		if (listReviewResponses == null || listReviewResponses.size() == 0) {
			return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_REVIEW_NOT_FOUND, null);
		} else {
			return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, listReviewResponses);
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<BaseResponse<AddReviewResponse>> add(@RequestBody @Valid AddReviewRequest request) {
		AddReviewResponse addReviewResponse = reviewService.add(request);
		return sendResponse(HttpStatus.CREATED, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY, addReviewResponse);
	}

	@PutMapping
	public ResponseEntity<BaseResponse<UpdateReviewResponse>> update(@RequestBody @Valid UpdateReviewRequest request) {
		UpdateReviewResponse updateReviewResponse = reviewService.update(request);
		return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_UPDATED_SUCCESSFULLY, updateReviewResponse);
	}

}
