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

import com.tobeto.java4a.hotelnow.services.abstracts.ReviewReplyService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviewreplies.AddReviewReplyRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviewreplies.UpdateReviewReplyRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviewreplies.AddReviewReplyResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviewreplies.ListReviewReplyResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviewreplies.UpdateReviewReplyResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/review-replies")
@AllArgsConstructor
public class ReviewRepliesController {
	
	private ReviewReplyService reviewReplyService;
	
	@GetMapping("/{id}")
	public ListReviewReplyResponse getById(@PathVariable int id) {
		return reviewReplyService.getById(id);
	}
	
	@GetMapping("/by-review-id/{reviewId}")
	public List<ListReviewReplyResponse> getByReviewId(@PathVariable int reviewId) {
		return reviewReplyService.getByReviewId(reviewId);
	}
	
	@GetMapping("/by-staff-id/{staffId}")
	public List<ListReviewReplyResponse> getByStaffId(@PathVariable int staffId) {
		return reviewReplyService.getByStaffId(staffId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AddReviewReplyResponse add(@RequestBody @Valid AddReviewReplyRequest request) {
		return reviewReplyService.add(request);
	}
	
	@PutMapping
	public UpdateReviewReplyResponse update(@RequestBody @Valid UpdateReviewReplyRequest request) {
		return reviewReplyService.update(request);
	}

}
