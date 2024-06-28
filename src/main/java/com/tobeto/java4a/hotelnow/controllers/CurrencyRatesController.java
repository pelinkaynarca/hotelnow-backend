package com.tobeto.java4a.hotelnow.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
				currencyService.convertForeignCurrencyToTurkishLira(Currency.valueOf(currencyCode.toUpperCase())));
	}
}
