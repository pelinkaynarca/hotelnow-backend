package com.tobeto.java4a.hotelnow.services.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.Review;
import com.tobeto.java4a.hotelnow.entities.concretes.ReviewReply;
import com.tobeto.java4a.hotelnow.entities.concretes.Staff;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviewreplies.AddReviewReplyRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviewreplies.UpdateReviewReplyRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviewreplies.AddReviewReplyResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviewreplies.ListReviewReplyResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviewreplies.UpdateReviewReplyResponse;

@Mapper
public interface ReviewReplyMapper {

	ReviewReplyMapper INSTANCE = Mappers.getMapper(ReviewReplyMapper.class);

	@Mapping(target = "reviewId", source = "review.id")
	ListReviewReplyResponse listResponseFromReviewReply(ReviewReply reviewReply);
	
	List<ListReviewReplyResponse> listResponsesFromReviewReplies(List<ReviewReply> reviewReplies);

	@Mapping(target = "reviewId", source = "review.id")
	AddReviewReplyResponse addResponseFromReviewReply(ReviewReply reviewReply);

	@Mapping(target = "reviewId", source = "review.id")
	UpdateReviewReplyResponse updateResponseFromReviewReply(ReviewReply reviewReply);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "status", ignore = true)
	@Mapping(target = "review.id", expression = "java(addReviewReplyRequest.getReviewId())")
	@Mapping(target = "staff", source = "staff")
	@Mapping(target = "repliedAt", ignore = true)
	ReviewReply reviewReplyFromAddRequest(AddReviewReplyRequest addReviewReplyRequest, Staff staff);

	@Mapping(target = "repliedAt", ignore = true)
	@Mapping(target = "reply", ignore = true)
	@Mapping(target = "id", expression = "java(updateReviewReplyRequest.getId())")
	@Mapping(target = "status", expression = "java(updateReviewReplyRequest.getStatus())")
	@Mapping(target = "review", source = "review")
	@Mapping(target = "staff", source = "staff")
	ReviewReply reviewReplyFromUpdateRequest(UpdateReviewReplyRequest updateReviewReplyRequest, Staff staff,
			Review review);

}
