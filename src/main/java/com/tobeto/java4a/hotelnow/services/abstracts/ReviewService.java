package com.tobeto.java4a.hotelnow.services.abstracts;

import java.util.List;

import com.tobeto.java4a.hotelnow.entities.concretes.Review;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviews.AddReviewRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviews.UpdateReviewRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.AddReviewResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.ListReviewResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.ListReviewResponseByHotelId;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.UpdateReviewResponse;

public interface ReviewService {
	
	ListReviewResponse getResponseById(int id);
	
	Review getById(int id);
	
	ListReviewResponse getByBookingId(int bookingId);
	
	List<ListReviewResponseByHotelId> getByHotelId(int hotelId);
	
	List<ListReviewResponse> getByCustomerId(int customerId);
	
	AddReviewResponse add(AddReviewRequest request);
	
	UpdateReviewResponse update(UpdateReviewRequest request);

}
