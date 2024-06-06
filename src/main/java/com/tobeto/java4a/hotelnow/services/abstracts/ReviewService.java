package com.tobeto.java4a.hotelnow.services.abstracts;

import java.util.List;

import com.tobeto.java4a.hotelnow.services.dtos.requests.reviews.AddReviewRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviews.UpdateReviewRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.AddReviewResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.ListReviewResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.UpdateReviewResponse;

public interface ReviewService {
	
	ListReviewResponse getById(int id);
	
	ListReviewResponse getByBookingId(int bookingId);
	
	List<ListReviewResponse> getByHotelId(int hotelId);
	
	AddReviewResponse add(AddReviewRequest request);
	
	UpdateReviewResponse update(UpdateReviewRequest request);

}
