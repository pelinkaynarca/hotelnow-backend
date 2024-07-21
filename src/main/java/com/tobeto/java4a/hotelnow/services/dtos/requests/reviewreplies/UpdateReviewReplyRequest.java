package com.tobeto.java4a.hotelnow.services.dtos.requests.reviewreplies;

import com.tobeto.java4a.hotelnow.services.enums.ReviewReplyStatus;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReviewReplyRequest {
	
	@Min(value = 1)
	private int id;
	
	private ReviewReplyStatus status;

}
