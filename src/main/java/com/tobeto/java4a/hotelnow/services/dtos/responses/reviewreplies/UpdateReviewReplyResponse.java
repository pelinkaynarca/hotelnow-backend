package com.tobeto.java4a.hotelnow.services.dtos.responses.reviewreplies;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReviewReplyResponse {

	private int id;

	private int reviewId;

	private String reply;

	private boolean approved;
	
	private LocalDateTime repliedAt;

}
