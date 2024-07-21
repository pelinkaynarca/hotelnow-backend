package com.tobeto.java4a.hotelnow.services.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.Customer;
import com.tobeto.java4a.hotelnow.entities.concretes.Review;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviews.AddReviewRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviews.UpdateReviewRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.AddReviewResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.ListReviewResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.UpdateReviewResponse;
import com.tobeto.java4a.hotelnow.services.enums.ReviewStatus;

@Mapper
public interface ReviewMapper {

	ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

	@Mapping(target = "bookingId", source = "booking.id")
	@Mapping(target = "customerId", source = "customer.id")
	@Mapping(target = "reviewStatus", source = "status")
	ListReviewResponse listResponseFromReview(Review review);
	
	List<ListReviewResponse> listResponsesFromReviews(List<Review> reviews);

	@Mapping(target = "bookingId", source = "booking.id")
	@Mapping(target = "customerId", source = "customer.id")
	AddReviewResponse addResponseFromReview(Review review);

	@Mapping(target = "bookingId", source = "booking.id")
	@Mapping(target = "customerId", source = "customer.id")
	@Mapping(target = "reviewStatus", source = "status")
	UpdateReviewResponse updateResponseFromReview(Review review);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "status", source = "reviewStatus")
	@Mapping(target = "reviewReplies", ignore = true)
	@Mapping(target = "reviewedAt", ignore = true)
	@Mapping(target = "booking.id", expression = "java(addReviewRequest.getBookingId())")
	@Mapping(target = "customer", source = "customer")
	Review reviewFromAddRequest(AddReviewRequest addReviewRequest, Customer customer, ReviewStatus reviewStatus);
	
	@Mapping(target = "reviewReplies", ignore = true)
	@Mapping(target = "rating", ignore = true)
	@Mapping(target = "booking", ignore = true)
	@Mapping(target = "customer", ignore = true)
	@Mapping(target = "review", ignore = true)
	@Mapping(target = "reviewedAt", ignore = true)
	@Mapping(target = "status", source = "reviewStatus")
	Review reviewFromUpdateRequest(UpdateReviewRequest updateReviewRequest);

}
