package com.tobeto.java4a.hotelnow.services.dtos.responses.reviews;

import java.time.LocalDateTime;

import com.tobeto.java4a.hotelnow.services.enums.ReviewStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListReviewResponse {
	
	private int id;

	private int customerId;

	private int bookingId;

	private String review;

	private byte rating;
	
	private LocalDateTime reviewedAt;
	
	private ReviewStatus reviewStatus;

}
