package com.tobeto.java4a.hotelnow.services.concretes;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.tobeto.java4a.hotelnow.entities.concretes.BookingHistory;
import com.tobeto.java4a.hotelnow.entities.concretes.User;
import com.tobeto.java4a.hotelnow.repositories.BookingHistoryRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.BookingHistoryService;
import com.tobeto.java4a.hotelnow.services.abstracts.UserService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookinghistories.AddBookingHistoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookinghistories.AddBookingHistoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookinghistories.ListBookingHistoryResponse;
import com.tobeto.java4a.hotelnow.services.mappers.BookingHistoryMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookingHistoryServiceImpl implements BookingHistoryService {

	private final BookingHistoryRepository bookingHistoryRepository;
	private final UserService userService;

	@Override
	public List<ListBookingHistoryResponse> getResponsesByBookingId(int bookingId) {
		List<BookingHistory> bookingHistories = bookingHistoryRepository.findByBookingId(bookingId);
		List<ListBookingHistoryResponse> bookingHistoryResponses = BookingHistoryMapper.INSTANCE
				.listResponsesFromBookingHistories(bookingHistories);
		return bookingHistoryResponses;
	}

	@Override
	public AddBookingHistoryResponse add(AddBookingHistoryRequest request) {
		String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User loggedInUser = (User) userService.loadUserByUsername(email);
		BookingHistory bookingHistory = BookingHistoryMapper.INSTANCE.bookingHistoryfromAddRequest(request,
				loggedInUser.getId());
		BookingHistory savedbookingHistory = addBookingHistory(bookingHistory);
		return BookingHistoryMapper.INSTANCE.addResponseFromBookingHistory(savedbookingHistory);
	}

	@Override
	public BookingHistory addBookingHistory(BookingHistory bookingHistory) {
		return bookingHistoryRepository.save(bookingHistory);
	}

}
