package com.tobeto.java4a.hotelnow.services.concretes;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.tobeto.java4a.hotelnow.core.utils.exceptions.types.AuthorizationException;
import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.entities.concretes.ReviewReply;
import com.tobeto.java4a.hotelnow.entities.concretes.Role;
import com.tobeto.java4a.hotelnow.entities.concretes.Staff;
import com.tobeto.java4a.hotelnow.entities.concretes.User;
import com.tobeto.java4a.hotelnow.repositories.ReviewReplyRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.ReviewReplyService;
import com.tobeto.java4a.hotelnow.services.abstracts.StaffService;
import com.tobeto.java4a.hotelnow.services.abstracts.UserService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviewreplies.AddReviewReplyRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.reviewreplies.UpdateReviewReplyRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviewreplies.AddReviewReplyResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviewreplies.ListReviewReplyResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviewreplies.UpdateReviewReplyResponse;
import com.tobeto.java4a.hotelnow.services.enums.ReviewReplyStatus;
import com.tobeto.java4a.hotelnow.services.mappers.ReviewReplyMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReviewReplyServiceImpl implements ReviewReplyService {

	private final ReviewReplyRepository reviewReplyRepository;
	private final UserService userService;
	private final StaffService staffService;

	@Override
	public ListReviewReplyResponse getResponseById(int id) {
		ReviewReply reviewReply = getById(id);
		return ReviewReplyMapper.INSTANCE.listResponseFromReviewReply(reviewReply);
	}

	@Override
	public ReviewReply getById(int id) {
		return reviewReplyRepository.findById(id).orElse(null);
	}

	@Override
	public List<ListReviewReplyResponse> getByReviewId(int reviewId) {
		List<ReviewReply> reviewReplies = reviewReplyRepository.findByReviewId(reviewId);
		List<ListReviewReplyResponse> listReviewReplyResponses = ReviewReplyMapper.INSTANCE
				.listResponsesFromReviewReplies(reviewReplies);
		return listReviewReplyResponses;
	}

	@Override
	public List<ListReviewReplyResponse> getByStaffId(int staffId) {
		List<ReviewReply> reviewReplies = reviewReplyRepository.findByStaffId(staffId);
		List<ListReviewReplyResponse> listReviewReplyResponses = ReviewReplyMapper.INSTANCE
				.listResponsesFromReviewReplies(reviewReplies);
		return listReviewReplyResponses;
	}

	@Override
	public List<ListReviewReplyResponse> getApprovedReplyResponsesByReviewId(int reviewId) {
		List<ReviewReply> reviewReplies = reviewReplyRepository.findByReviewIdAndStatus(reviewId,
				ReviewReplyStatus.APPR);
		List<ListReviewReplyResponse> listReviewReplyResponses = ReviewReplyMapper.INSTANCE
				.listResponsesFromReviewReplies(reviewReplies);
		return listReviewReplyResponses;
	}

	@Override
	public List<ListReviewReplyResponse> getPendingReplyResponses() {
		loggedInUserMustBeAdmin();
		List<ReviewReply> reviewReplies = reviewReplyRepository.findByStatus(ReviewReplyStatus.PEND);
		List<ListReviewReplyResponse> listReviewReplyResponses = ReviewReplyMapper.INSTANCE
				.listResponsesFromReviewReplies(reviewReplies);
		return listReviewReplyResponses;
	}

	@Override
	public AddReviewReplyResponse add(AddReviewReplyRequest request) {
		String emailOfLoggedInStaff = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User loggedInUser = (User) userService.loadUserByUsername(emailOfLoggedInStaff);
		Staff loggedInStaff = staffService.getById(loggedInUser.getId());

		ReviewReply reviewReply = ReviewReplyMapper.INSTANCE.reviewReplyFromAddRequest(request, loggedInStaff);
		reviewReply.setStatus(ReviewReplyStatus.PEND);
		ReviewReply savedReviewReply = reviewReplyRepository.save(reviewReply);
		return ReviewReplyMapper.INSTANCE.addResponseFromReviewReply(savedReviewReply);
	}

	@Override
	public UpdateReviewReplyResponse update(UpdateReviewReplyRequest request) {
		loggedInUserMustBeAdmin();
		ReviewReply reviewReply = getById(request.getId());
		reviewReply.setStatus(request.getStatus());
		ReviewReply savedReviewReply = reviewReplyRepository.save(reviewReply);
		return ReviewReplyMapper.INSTANCE.updateResponseFromReviewReply(savedReviewReply);
	}

	private void loggedInUserMustBeAdmin() {
		List<Role> rolesOfLoggedInUser = SecurityContextHolder.getContext().getAuthentication().getAuthorities()
				.stream().map(r -> Role.valueOf(r.getAuthority())).toList();
		if (!rolesOfLoggedInUser.contains(Role.ADMIN))
			throw new AuthorizationException(Messages.Error.AUTHORIZATION_VIOLATION);
	}
}
