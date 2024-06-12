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
import com.tobeto.java4a.hotelnow.services.mappers.PaymentMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

	private final PaymentRepository paymentRepository;
//	private final BookingService bookingService;

	@Override
	public Payment getByBookingId(int bookingId) {
		return paymentRepository.findByBookingId(bookingId).orElseThrow();
	}

	@Override
	public ListPaymentResponse getResponseByBookingId(int bookingId) {
		Payment payment = getByBookingId(bookingId);
		ListPaymentResponse listPaymentResponse = PaymentMapper.INSTANCE.listResponseFromPayment(payment);
		return listPaymentResponse;
	}

	@Override
	public AddPaymentResponse add(AddPaymentRequest request) {
		Payment payment = PaymentMapper.INSTANCE.paymentFromAddRequest(request);
		Payment savedPayment = addPayment(payment);
		return PaymentMapper.INSTANCE.addResponseFromPayment(savedPayment);
	}

	@Override
	public UpdatePaymentResponse update(UpdatePaymentRequest request) {
		Payment payment = getByBookingId(request.getBookingId());
		payment = PaymentMapper.INSTANCE.paymentFromUpdateRequest(request);
		Payment savedPayment = paymentRepository.save(payment);
		return PaymentMapper.INSTANCE.updateResponseFromPayment(savedPayment);
	}

	@Override
	public Payment addPayment(Payment payment) {
		return paymentRepository.save(payment);
	}

}
