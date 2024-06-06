package com.tobeto.java4a.hotelnow.services.dtos.responses.reviewreplies;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddReviewReplyResponse {
	
	private int id;
	
	private int reviewId;
	
	private String reply;
	
}
