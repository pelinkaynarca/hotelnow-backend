package com.tobeto.java4a.hotelnow.core.services.abstracts;

import com.tobeto.java4a.hotelnow.core.enums.Currency;

public interface CurrencyService {

	Double calculateForeignCurrencyEquivalentOfTLAmount(double tlAmount, Currency currency);

	Double getTurkishLiraEquivalentOfForeignCurrency(Currency currency);
}
