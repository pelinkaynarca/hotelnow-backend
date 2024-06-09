package com.tobeto.java4a.hotelnow.entities.concretes;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;

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

	@Generated
	@ColumnDefault("now()")
	@Column(name = "edited_at", nullable = false, updatable = false)
	private LocalDateTime editedAt;

	@Column(name = "status", length = 10, nullable = false, updatable = false)
	@Enumerated(EnumType.STRING)
	private BookingStatus status;

	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(optional = false)
	@JoinColumn(name = "booking_id")
	private Booking booking;

	@ManyToOne
	@JoinColumn(name = "cancellation_reason_id")
	private CancellationReason cancellationReason;
}
