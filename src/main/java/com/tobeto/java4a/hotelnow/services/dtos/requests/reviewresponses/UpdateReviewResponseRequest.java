package com.tobeto.java4a.hotelnow.services.dtos.requests.reviewresponses;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReviewResponseRequest {
	
	@Min(value = 1)
	private int id;
	
	private boolean approved;

}
