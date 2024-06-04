package com.tobeto.java4a.hotelnow.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.tobeto.java4a.hotelnow.entities.abstracts.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "bookings")
public class Booking extends BaseEntity {

	@Column(name = "booked_at", nullable = false)
	private LocalDateTime bookedAt;

	@Column(name = "check_in_date", nullable = false)
	private LocalDate checkInDate;

	@Column(name = "check_out_date", nullable = false)
	private LocalDate checkOutDate;

	@Column(name = "guest_count", nullable = false)
	private short guestCount;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;

	@OneToOne(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Review review;

	@OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<BookedRoomType> bookedRoomTypes;
}
