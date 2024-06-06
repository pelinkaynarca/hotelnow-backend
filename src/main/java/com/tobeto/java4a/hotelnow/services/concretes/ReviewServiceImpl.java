package com.tobeto.java4a.hotelnow.services.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tobeto.java4a.hotelnow.repositories.ReviewRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.ReviewService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviews.AddReviewRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviews.UpdateReviewRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.AddReviewResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.ListReviewResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.UpdateReviewResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
	
	private ReviewRepository reviewRepository;

	@Override
	public ListReviewResponse getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListReviewResponse getByBookingId(int bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ListReviewResponse> getByHotelId(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddReviewResponse add(AddReviewRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateReviewResponse update(UpdateReviewRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
