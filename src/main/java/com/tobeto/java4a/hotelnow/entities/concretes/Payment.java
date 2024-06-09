package com.tobeto.java4a.hotelnow.entities.concretes;

import java.time.LocalDateTime;

import com.tobeto.java4a.hotelnow.core.enums.Currency;
import com.tobeto.java4a.hotelnow.core.enums.PaymentStatus;
import com.tobeto.java4a.hotelnow.core.enums.PaymentType;
import com.tobeto.java4a.hotelnow.entities.abstracts.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
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
@Table(name = "payments")
public class Payment extends BaseEntity {

	@Column(name = "total_price", nullable = false)
	private int totalPrice;

	@Column(name = "card_no", nullable = false)
	private String cardNo;

	@Column(name = "payment_date", nullable = false)
	private LocalDateTime paymentDate;

	@Column(name = "payment_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;

	@Column(name = "payment_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;

	@Column(name = "currency", nullable = false)
	@Enumerated(EnumType.STRING)
	private Currency currency;

	@OneToOne(optional = false)
	@JoinColumn(name = "booking_id")
	private Booking booking;
}
