package com.tobeto.java4a.hotelnow.services.abstracts;

import java.util.List;

import com.tobeto.java4a.hotelnow.entities.concretes.BookingHistory;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookinghistories.AddBookingHistoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookinghistories.AddBookingHistoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookinghistories.ListBookingHistoryResponse;

public interface BookingHistoryService {
	
	List<ListBookingHistoryResponse> getResponsesByBookingId(int bookingId);
	
	AddBookingHistoryResponse add(AddBookingHistoryRequest request);
	
	BookingHistory addBookingHistory(BookingHistory bookingHistory);

}
