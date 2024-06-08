package com.tobeto.java4a.hotelnow.services.dtos.requests.bookinghistories;

import com.tobeto.java4a.hotelnow.core.enums.BookingStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddBookingHistoryRequest {

	private int userId;

	private int bookingId;

//	private LocalDateTime editedAt;

	private BookingStatus status;

	private Integer cancellationReasonId;

}
