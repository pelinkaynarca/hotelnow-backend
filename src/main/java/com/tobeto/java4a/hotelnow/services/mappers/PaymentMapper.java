package com.tobeto.java4a.hotelnow.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.Payment;
import com.tobeto.java4a.hotelnow.services.dtos.requests.payments.AddPaymentRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.payments.UpdatePaymentRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.payments.AddPaymentResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.payments.ListPaymentResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.payments.UpdatePaymentResponse;

@Mapper
public interface PaymentMapper {

	PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

	@Mapping(target = "bookingId", source = "booking.id")
	ListPaymentResponse listResponseFromPayment(Payment payment);

	@Mapping(target = "bookingId", source = "booking.id")
	AddPaymentResponse addResponseFromPayment(Payment payment);

	@Mapping(target = "bookingId", source = "booking.id")
	UpdatePaymentResponse updateResponseFromPayment(Payment payment);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "paymentDate", ignore = true)
	@Mapping(target = "booking.id", source = "bookingId")
	Payment paymentFromAddRequest(AddPaymentRequest addPaymentRequest, Integer bookingId);
	
	@Mapping(target = "booking.id", source = "bookingId")
	Payment paymentFromUpdateRequest(UpdatePaymentRequest updatePaymentRequest);

}
