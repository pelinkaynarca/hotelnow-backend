package com.tobeto.java4a.hotelnow.services.dtos.requests.payments;

import com.tobeto.java4a.hotelnow.services.enums.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePaymentRequest {

//	private int id;

	private int bookingId;

//	private PaymentType paymentType;

//	private double totalPrice;

//	private String cardNo;

	private PaymentStatus paymentStatus;

//	private Currency currency;

//	private LocalDateTime paymentDate;

}
