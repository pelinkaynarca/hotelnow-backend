package com.tobeto.java4a.hotelnow.services.dtos.responses.reviewreplies;

import com.tobeto.java4a.hotelnow.services.enums.ReviewReplyStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListReviewReplyResponse {
	
	private int id;

	private int reviewId;

	private String reply;

	private ReviewReplyStatus status;

}
