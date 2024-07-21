package com.tobeto.java4a.hotelnow.services.dtos.requests.payments;

import com.tobeto.java4a.hotelnow.services.enums.Currency;
import com.tobeto.java4a.hotelnow.services.enums.PaymentStatus;
import com.tobeto.java4a.hotelnow.services.enums.PaymentType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddPaymentRequest {

	@Min(value = 1)
	private int bookingId;

	private PaymentType paymentType;

	private double totalPrice;

	@NotBlank
	private String cardNo;

	private PaymentStatus paymentStatus;

	private Currency currency;

}
