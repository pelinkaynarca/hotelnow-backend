package com.tobeto.java4a.hotelnow.services.dtos.requests.bookings;

import java.time.LocalDate;
import java.util.List;

import com.tobeto.java4a.hotelnow.services.dtos.requests.bookedroomtypes.AddBookedRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.payments.AddPaymentRequest;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddBookingRequest {
	
	@Min(value = 1)
	private int hotelId;
	
//	@Min(value = 1)
//	private int customerId;
	
	@NotNull
	@FutureOrPresent
	private LocalDate checkInDate;
	
	@NotNull
	@Future
	private LocalDate checkOutDate;
	
	@Min(value = 1)
	private int guestCount;
	
	private List<AddBookedRoomTypeRequest> bookedRoomTypes;
	
	private AddPaymentRequest payment;

}
