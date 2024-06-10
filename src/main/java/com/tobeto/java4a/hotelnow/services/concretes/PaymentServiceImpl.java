package com.tobeto.java4a.hotelnow.services.concretes;

import org.springframework.stereotype.Service;

import com.tobeto.java4a.hotelnow.entities.concretes.Payment;
import com.tobeto.java4a.hotelnow.repositories.PaymentRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.PaymentService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.payments.AddPaymentRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.payments.UpdatePaymentRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.payments.AddPaymentResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.payments.ListPaymentResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.payments.UpdatePaymentResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {
	
	private final PaymentRepository paymentRepository;

	@Override
	public ListPaymentResponse getByBookingId(int bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddPaymentResponse add(AddPaymentRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdatePaymentResponse update(UpdatePaymentRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment addPayment(Payment payment) {
		return paymentRepository.save(payment);
	}

}
