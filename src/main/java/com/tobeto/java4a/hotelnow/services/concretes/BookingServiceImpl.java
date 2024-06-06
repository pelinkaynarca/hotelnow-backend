package com.tobeto.java4a.hotelnow.services.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tobeto.java4a.hotelnow.repositories.BookingRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.BookingService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookings.AddBookingRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookings.AddBookingResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookings.ListBookingResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookingServiceImpl implements BookingService{
	
	private BookingRepository bookingRepository;

	@Override
	public ListBookingResponse getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ListBookingResponse> getByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ListBookingResponse> getByHotelId(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddBookingResponse add(AddBookingRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
