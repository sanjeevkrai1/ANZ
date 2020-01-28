package com.anz.fx.calculator.service;

import com.anz.fx.calculator.costants.AnzFxCurrencies;

public interface AnzFxCurrencyFormatterService {
    String formatOutputAsPerCurrency(String actualAmount, Double convertedAmount, AnzFxCurrencies ccy1, AnzFxCurrencies ccy2);
}
