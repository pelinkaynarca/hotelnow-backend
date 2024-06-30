package com.tobeto.java4a.hotelnow.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tobeto.java4a.hotelnow.core.enums.Currency;
import com.tobeto.java4a.hotelnow.core.services.CurrencyService;
import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/currency-rates")
@AllArgsConstructor
public class CurrencyRatesController extends BaseController {

	private CurrencyService currencyService;

	@GetMapping("/{currencyCode}")
	public ResponseEntity<BaseResponse<Double>> foreignCurrencyToTurkishLira(@PathVariable String currencyCode) {
		return sendResponse(HttpStatus.OK, Messages.Success.CUSTOM_LISTED_SUCCESSFULLY,
				currencyService.getTurkishLiraEquivalentOfForeignCurrency(Currency.valueOf(currencyCode.toUpperCase())));
	}

	@GetMapping("/convert")
	public ResponseEntity<Double> convertAmountToCurrency(
			@RequestParam("amount") double amount,
			@RequestParam("currency") Currency currency) {
		Double foreignCurrencyAmount = currencyService.calculateForeignCurrencyEquivalentOfTLAmount(amount, currency);
		if (foreignCurrencyAmount != null) {
			return ResponseEntity.ok(foreignCurrencyAmount);
		} else {
			System.out.println("Invalid currency or amount: " + amount + " " + currency);
			return ResponseEntity.badRequest().body(null);
		}
	}
}
