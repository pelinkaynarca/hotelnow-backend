package com.tobeto.java4a.hotelnow.services.dtos.responses.reviews;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddReviewResponse {
	
	private int id;
	
	private int customerId;
	
	private int bookingId;
	
	private String review;
	
	private byte rating;

}
