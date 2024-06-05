package com.tobeto.java4a.hotelnow.services.dtos.requests.bookings;

import java.time.LocalDate;

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
	
	@NotNull
	@FutureOrPresent
	private LocalDate checkInDate;
	
	@NotNull
	@Future
	private LocalDate checkOutDate;
	
	@Min(value = 1)
	private int guestCount;

}
