package com.tobeto.java4a.hotelnow.services.dtos.responses.bookings;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.tobeto.java4a.hotelnow.services.dtos.responses.customers.ListCustomerResponse;
import com.tobeto.java4a.hotelnow.services.enums.BookingStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CancelBookingResponse {

	private int id;

	private int hotelId;
	
	private BookingStatus status;

	private LocalDateTime bookedAt;

	private LocalDate checkInDate;

	private LocalDate checkOutDate;

	private int guestCount;

	private ListCustomerResponse customer;

}
