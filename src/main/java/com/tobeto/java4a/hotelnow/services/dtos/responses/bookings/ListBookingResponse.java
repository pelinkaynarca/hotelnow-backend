package com.tobeto.java4a.hotelnow.services.dtos.responses.bookings;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.tobeto.java4a.hotelnow.services.dtos.responses.customers.ListCustomerResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListBookingResponse {
	
	private int id;
	
	private int hotelId;
	
	private LocalDateTime bookedAt;
	
	private LocalDate checkInDate;
	
	private LocalDate checkOutDate;
	
	private int guestCount;
	
	private ListCustomerResponse customer;

}
