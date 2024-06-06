package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.requests.payments.AddPaymentRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.payments.UpdatePaymentRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.payments.AddPaymentResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.payments.ListPaymentResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.payments.UpdatePaymentResponse;

public interface PaymentService {
	
	ListPaymentResponse getByBookingId(int bookingId);
	
	AddPaymentResponse add(AddPaymentRequest request);
	
	UpdatePaymentResponse update(UpdatePaymentRequest request);

}
