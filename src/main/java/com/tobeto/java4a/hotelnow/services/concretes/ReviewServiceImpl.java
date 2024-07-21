package com.tobeto.java4a.hotelnow.services.concretes;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.tobeto.java4a.hotelnow.core.utils.exceptions.types.AuthorizationException;
import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.entities.concretes.Booking;
import com.tobeto.java4a.hotelnow.entities.concretes.Customer;
import com.tobeto.java4a.hotelnow.entities.concretes.Review;
import com.tobeto.java4a.hotelnow.entities.concretes.Role;
import com.tobeto.java4a.hotelnow.entities.concretes.User;
import com.tobeto.java4a.hotelnow.repositories.ReviewRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.BookingService;
import com.tobeto.java4a.hotelnow.services.abstracts.CustomerService;
import com.tobeto.java4a.hotelnow.services.abstracts.ReviewService;
import com.tobeto.java4a.hotelnow.services.abstracts.UserService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviews.AddReviewRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviews.UpdateReviewRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.AddReviewResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.ListReviewResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.ListReviewResponseByHotelId;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.UpdateReviewResponse;
import com.tobeto.java4a.hotelnow.services.enums.ReviewStatus;
import com.tobeto.java4a.hotelnow.services.mappers.ReviewMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

	private final ReviewRepository reviewRepository;
	private final BookingService bookingService;
	private final UserService userService;
	private final CustomerService customerService;

	@Override
	public ListReviewResponse getResponseById(int id) {
		Review review = getById(id);
		return ReviewMapper.INSTANCE.listResponseFromReview(review);
	}

	@Override
	public Review getById(int id) {
		return reviewRepository.findById(id).orElse(null);
	}

	@Override
	public List<ListReviewResponse> getByCustomerId(int customerId) {
		List<Review> reviews = reviewRepository.findByCustomerId(customerId);
		return ReviewMapper.INSTANCE.listResponsesFromReviews(reviews);
	}

	@Override
	public ListReviewResponse getByBookingId(int bookingId) {
		Booking booking = bookingService.getById(bookingId);
		Review review = booking.getReview();
		return ReviewMapper.INSTANCE.listResponseFromReview(review);
	}

	@Override
	public List<ListReviewResponseByHotelId> getByHotelId(int hotelId) {
		List<ListReviewResponseByHotelId> reviews = reviewRepository.findByHotelId(hotelId, ReviewStatus.APPR.name());
		return reviews;
	}

	@Override
	public AddReviewResponse add(AddReviewRequest request) {
		String emailOfLoggedInStaff = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User loggedInUser = (User) userService.loadUserByUsername(emailOfLoggedInStaff);
		Customer customer = customerService.getById(loggedInUser.getId());
		Review review = ReviewMapper.INSTANCE.reviewFromAddRequest(request, customer, ReviewStatus.PEND);
		Review savedReview = reviewRepository.save(review);
		return ReviewMapper.INSTANCE.addResponseFromReview(savedReview);
	}

	@Override
	public UpdateReviewResponse update(UpdateReviewRequest request) {
		loggedInUserMustBeAdmin();
		Review review = getById(request.getId());
		review.setStatus(request.getReviewStatus());
		Review savedReview = reviewRepository.save(review);
		return ReviewMapper.INSTANCE.updateResponseFromReview(savedReview);
	}

	private void loggedInUserMustBeAdmin() {
		List<Role> rolesOfLoggedInUser = SecurityContextHolder.getContext().getAuthentication().getAuthorities()
				.stream().map(r -> Role.valueOf(r.getAuthority())).toList();
		if (!rolesOfLoggedInUser.contains(Role.ADMIN))
			throw new AuthorizationException(Messages.Error.AUTHORIZATION_VIOLATION);
	}
}
