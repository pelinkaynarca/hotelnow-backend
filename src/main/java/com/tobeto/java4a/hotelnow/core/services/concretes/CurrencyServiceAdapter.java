package com.tobeto.java4a.hotelnow.core.services.concretes;

import org.springframework.stereotype.Service;
import com.tobeto.java4a.hotelnow.core.enums.Currency;
import com.tobeto.java4a.hotelnow.core.services.abstracts.CurrencyService;
import com.tobeto.java4a.hotelnow.core.services.webservices.TcmbCurrencyClient;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CurrencyServiceAdapter implements CurrencyService {
	
	private final TcmbCurrencyClient tcmbCurrencyClient;

	public Double calculateForeignCurrencyEquivalentOfTLAmount(double tlAmount, Currency currency) {
		if (currency == Currency.TRY) {
			return tlAmount;
		}

		Double currentExchangeRate = getTurkishLiraEquivalentOfForeignCurrency(currency);
		if (currentExchangeRate != null) {
			return tlAmount / currentExchangeRate;
		} else {
			return null;
		}
	}
	
	public Double getTurkishLiraEquivalentOfForeignCurrency(Currency currency) {
		return tcmbCurrencyClient.getTurkishLiraEquivalentOfForeignCurrency(currency);
	}
}
