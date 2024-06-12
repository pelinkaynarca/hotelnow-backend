package com.tobeto.java4a.hotelnow.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.abstracts.PaymentService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.payments.AddPaymentRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.payments.UpdatePaymentRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.payments.AddPaymentResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.payments.ListPaymentResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.payments.UpdatePaymentResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/payments")
public class PaymentsController extends BaseController {

	private PaymentService paymentService;

	@GetMapping("/by-booking-id/{bookingId}")
	public ResponseEntity<BaseResponse<ListPaymentResponse>> getByBookingId(@PathVariable int bookingId) {
		ListPaymentResponse listPaymentResponse = paymentService.getResponseByBookingId(bookingId);
		if (listPaymentResponse == null) {
			return sendResponse(HttpStatus.NOT_FOUND, Messages.Error.CUSTOM_PAYMENT_NOT_FOUND, null);
		} else {
			return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY, listPaymentResponse);
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<BaseResponse<AddPaymentResponse>> add(@RequestBody @Valid AddPaymentRequest request) {
		AddPaymentResponse addPaymentResponse = paymentService.add(request);
		return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY, addPaymentResponse);
	}

	@PutMapping
	public ResponseEntity<BaseResponse<UpdatePaymentResponse>> update(
			@RequestBody @Valid UpdatePaymentRequest request) {
		UpdatePaymentResponse updatePaymentResponse = paymentService.update(request);
		return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_CREATED_SUCCESSFULLY, updatePaymentResponse);
	}
}
