package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.entities.concretes.Payment;
import com.tobeto.java4a.hotelnow.services.dtos.requests.payments.AddPaymentRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.payments.UpdatePaymentRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.payments.AddPaymentResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.payments.ListPaymentResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.payments.UpdatePaymentResponse;

public interface PaymentService {
	
	Payment getByBookingId(int bookingId);
	
	ListPaymentResponse getResponseByBookingId(int bookingId);
	
	AddPaymentResponse add(AddPaymentRequest request);
	
	Payment addPayment(Payment payment);
	
	UpdatePaymentResponse update(UpdatePaymentRequest request);

}
