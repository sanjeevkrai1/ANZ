package com.anz.fx.calculator.model;

import com.anz.fx.calculator.costants.AnzFxCurrencies;

public class AnzFxCurrencyConversion {
    private final AnzFxCurrencies base;
    private final AnzFxCurrencies terms;
    private final String amount;

    public AnzFxCurrencyConversion(AnzFxCurrencies base, AnzFxCurrencies terms, String amount) {
        this.base = base;
        this.terms = terms;
        this.amount = amount;
    }

    public AnzFxCurrencies getBase() {
        return base;
    }

    public AnzFxCurrencies getTerms() {
        return terms;
    }

    public Double getAmount() {
        return Double.parseDouble(amount);
    }

    public String getAmountInString() {
        return amount;
    }
}
