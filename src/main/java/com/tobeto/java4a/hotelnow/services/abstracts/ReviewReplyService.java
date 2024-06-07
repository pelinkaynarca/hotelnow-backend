package com.tobeto.java4a.hotelnow.services.abstracts;

import java.util.List;

import com.tobeto.java4a.hotelnow.services.dtos.requests.reviewreplies.AddReviewReplyRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviewreplies.UpdateReviewReplyRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviewreplies.AddReviewReplyResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviewreplies.ListReviewReplyResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviewreplies.UpdateReviewReplyResponse;

public interface ReviewReplyService {
	
	ListReviewReplyResponse getById(int id);
	
	List<ListReviewReplyResponse> getByReviewId(int reviewId);
	
	List<ListReviewReplyResponse> getByStaffId(int staffId);
	
	AddReviewReplyResponse add(AddReviewReplyRequest request);
	
	UpdateReviewReplyResponse update(UpdateReviewReplyRequest request);

}
