package com.tobeto.java4a.hotelnow.services.abstracts;

import java.util.List;

import com.tobeto.java4a.hotelnow.entities.concretes.Booking;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookings.AddBookingRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookings.CancelBookingRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookings.AddBookingResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookings.CancelBookingResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookings.ListBookingResponse;

public interface BookingService {

	Booking getById(int id);

	ListBookingResponse getResponseById(int id);

	List<ListBookingResponse> getByCustomerId(int customerId);

	List<ListBookingResponse> getByHotelId(int hotelId);

	List<ListBookingResponse> getPendings();

	List<ListBookingResponse> getApproveds();

	List<ListBookingResponse> getCancelleds();

	AddBookingResponse add(AddBookingRequest request);

	void approve(int bookingId);

	CancelBookingResponse cancel(CancelBookingRequest request);

}
