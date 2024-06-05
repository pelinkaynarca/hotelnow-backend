package com.tobeto.java4a.hotelnow.services.dtos.requests.reviews;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddReviewRequest {
	
	@Min(value = 1)
	private int bookingId;
	
	@NotBlank
	private String review;
	
	@Min(value = 1)
	@Max(value = 10)
	private byte rating;

}
