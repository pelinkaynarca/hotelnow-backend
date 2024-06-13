package com.tobeto.java4a.hotelnow.services.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tobeto.java4a.hotelnow.entities.concretes.ReviewReply;
import com.tobeto.java4a.hotelnow.repositories.ReviewReplyRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.ReviewReplyService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviewreplies.AddReviewReplyRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviewreplies.UpdateReviewReplyRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviewreplies.AddReviewReplyResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviewreplies.ListReviewReplyResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviewreplies.UpdateReviewReplyResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReviewReplyServiceImpl implements ReviewReplyService{
	
	private final ReviewReplyRepository reviewReplyRepository;

	@Override
	public ListReviewReplyResponse getResponseById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ReviewReply getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<ListReviewReplyResponse> getByReviewId(int reviewId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ListReviewReplyResponse> getByStaffId(int staffId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddReviewReplyResponse add(AddReviewReplyRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateReviewReplyResponse update(UpdateReviewReplyRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
