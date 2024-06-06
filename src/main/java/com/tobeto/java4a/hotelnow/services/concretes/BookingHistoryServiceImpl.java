package com.tobeto.java4a.hotelnow.services.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tobeto.java4a.hotelnow.repositories.BookingHistoryRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.BookingHistoryService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookinghistories.AddBookingHistoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookinghistories.AddBookingHistoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookinghistories.ListBookingHistoryResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookingHistoryServiceImpl implements BookingHistoryService{
	
	private BookingHistoryRepository bookingHistoryRepository;

	@Override
	public List<ListBookingHistoryResponse> getByBookingId(int bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddBookingHistoryResponse add(AddBookingHistoryRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
