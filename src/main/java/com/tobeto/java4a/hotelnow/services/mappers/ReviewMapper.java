package com.tobeto.java4a.hotelnow.services.mappers;

import java.time.LocalDateTime;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.Customer;
import com.tobeto.java4a.hotelnow.entities.concretes.Review;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviews.AddReviewRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.AddReviewResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.ListReviewResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.UpdateReviewResponse;

@Mapper
public interface ReviewMapper {

	ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

	@Mapping(target = "bookingId", source = "booking.id")
	@Mapping(target = "customerId", source = "customer.id")
	ListReviewResponse listResponseFromReview(Review review);

	@Mapping(target = "bookingId", source = "booking.id")
	@Mapping(target = "customerId", source = "customer.id")
	AddReviewResponse addResponseFromReview(Review review);

	@Mapping(target = "bookingId", source = "booking.id")
	@Mapping(target = "customerId", source = "customer.id")
	UpdateReviewResponse updateResponseFromReview(Review review);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "approved", ignore = true)
	@Mapping(target = "reviewReplies", ignore = true)
	@Mapping(target = "booking.id", expression = "java(addReviewRequest.getBookingId())")
	@Mapping(target = "customer", source = "customer")
	@Mapping(target = "reviewedAt", source = "reviewedAt")
	Review reviewFromAddRequest(AddReviewRequest addReviewRequest, Customer customer, LocalDateTime reviewedAt);

}
