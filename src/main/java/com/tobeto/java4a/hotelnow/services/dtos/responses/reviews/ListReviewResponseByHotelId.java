package com.tobeto.java4a.hotelnow.services.dtos.responses.reviews;

import java.time.LocalDateTime;

public interface ListReviewResponseByHotelId {
	int getCustomerId();
	String getReview();
	byte getRating();
	LocalDateTime getReviewedAt();
	String getFirstName();
	String getLastName();
	String getHotelName();
}
