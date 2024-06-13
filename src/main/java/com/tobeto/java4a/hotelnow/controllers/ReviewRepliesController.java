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
import com.tobeto.java4a.hotelnow.services.abstracts.ReviewReplyService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviewreplies.AddReviewReplyRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviewreplies.UpdateReviewReplyRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviewreplies.AddReviewReplyResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviewreplies.ListReviewReplyResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviewreplies.UpdateReviewReplyResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/review-replies")
@AllArgsConstructor
public class ReviewRepliesController extends BaseController {

	private ReviewReplyService reviewReplyService;

	@GetMapping("/{id}")
	public ResponseEntity<BaseResponse<ListReviewReplyResponse>> getById(@PathVariable int id) {
		ListReviewReplyResponse listReviewReplyResponse = reviewReplyService.getResponseById(id);
		if (listReviewReplyResponse == null) {
			return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_REVIEW_REPLY_NOT_FOUND, null);
		} else {
			return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, listReviewReplyResponse);
		}
	}

	@GetMapping("/by-review-id/{reviewId}")
	public ResponseEntity<BaseResponse<List<ListReviewReplyResponse>>> getByReviewId(@PathVariable int reviewId) {
		List<ListReviewReplyResponse> listReviewReplyResponses = reviewReplyService.getByReviewId(reviewId);
		if (listReviewReplyResponses == null || listReviewReplyResponses.size() == 0) {
			return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_REVIEW_REPLY_NOT_FOUND, null);
		} else {
			return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, listReviewReplyResponses);
		}
	}

	@GetMapping("/by-staff-id/{staffId}")
	public ResponseEntity<BaseResponse<List<ListReviewReplyResponse>>> getByStaffId(@PathVariable int staffId) {
		List<ListReviewReplyResponse> listReviewReplyResponses = reviewReplyService.getByStaffId(staffId);
		if (listReviewReplyResponses == null || listReviewReplyResponses.size() == 0) {
			return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_REVIEW_REPLY_NOT_FOUND, null);
		} else {
			return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, listReviewReplyResponses);
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<BaseResponse<AddReviewReplyResponse>> add(@RequestBody @Valid AddReviewReplyRequest request) {
		AddReviewReplyResponse addReviewReplyResponse = reviewReplyService.add(request);
		return sendResponse(HttpStatus.CREATED, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY, addReviewReplyResponse);
	}

	@PutMapping
	public ResponseEntity<BaseResponse<UpdateReviewReplyResponse>> update(
			@RequestBody @Valid UpdateReviewReplyRequest request) {
		UpdateReviewReplyResponse updateReviewReplyResponse = reviewReplyService.update(request);
		return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_UPDATED_SUCCESSFULLY, updateReviewReplyResponse);
	}

}
