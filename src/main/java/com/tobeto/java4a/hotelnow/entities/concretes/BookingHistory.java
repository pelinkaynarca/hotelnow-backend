package com.tobeto.java4a.hotelnow.entities.concretes;

import java.time.LocalDateTime;

import com.tobeto.java4a.hotelnow.core.enums.BookingStatus;
import com.tobeto.java4a.hotelnow.entities.abstracts.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking_histories")
public class BookingHistory extends BaseEntity {

	@Column(name = "edited_at")
	private LocalDateTime editedAt;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private BookingStatus status;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "booking_id", nullable = false)
	private Booking booking;
	
	@ManyToOne
	@JoinColumn(name = "cancelation_reason_id")
	private CancelationReason cancelationReason;
}
