package com.tobeto.java4a.hotelnow.services.abstracts;

import java.util.List;

import com.tobeto.java4a.hotelnow.services.dtos.requests.bookinghistories.AddBookingHistoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookinghistories.AddBookingHistoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookinghistories.ListBookingHistoryResponse;

public interface BookingHistoryService {
	
	List<ListBookingHistoryResponse> getByBookingId(int bookingId);
	
	AddBookingHistoryResponse add(AddBookingHistoryRequest request);

}
