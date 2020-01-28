package com.anz.fx.calculator.service.impl;

import java.util.Map;

import com.anz.fx.calculator.costants.AnzFxConstants;
import com.anz.fx.calculator.costants.AnzFxCurrencies;
import com.anz.fx.calculator.model.AnzFxCurrencyConversion;
import com.anz.fx.calculator.service.AnzFxCurrencyConvertService;

public class AnzFxCurrencyConvertServiceImpl implements AnzFxCurrencyConvertService {
    private String[][] crossCurrencyTable;
    private Map<String, Double> currencyExchangeRates;

    public AnzFxCurrencyConvertServiceImpl(String[][] crossCurrencyTable, Map<String, Double> currencyExchangeRates) {
        this.crossCurrencyTable = crossCurrencyTable;
        this.currencyExchangeRates = currencyExchangeRates;
    }

    @Override
    public double convert(AnzFxCurrencyConversion currencyConversionModel) {
        return calculate(currencyConversionModel.getBase(), currencyConversionModel.getTerms(), currencyConversionModel.getAmount());
    }

    private Double calculate(AnzFxCurrencies base, AnzFxCurrencies term, Double amount) {

        String crossMatrixResult = crossCurrencyTable[base.ordinal()][term.ordinal()];

        if (crossMatrixResult.equals(AnzFxConstants.DIRECT)) {
            return calculateDirectRate(base, term, amount);
        } else if (crossMatrixResult.equals(AnzFxConstants.INVERSE)) {
            return calculateInverseRate(base, term, amount);
        } else if (crossMatrixResult.equals(AnzFxConstants.SAME_CURRENCY)) {
            return amount;
        } else {
            amount = calculate(base, AnzFxCurrencies.valueOf(crossMatrixResult), amount);
            return calculate(AnzFxCurrencies.valueOf(crossMatrixResult), term, amount);
        }

    }


    private Double calculateDirectRate(AnzFxCurrencies base, AnzFxCurrencies term, Double amount) {
        return currencyExchangeRates.get(base.name() + term.name()) * amount;
    }

    private Double calculateInverseRate(AnzFxCurrencies base, AnzFxCurrencies term, Double amount) {
        return (1 / currencyExchangeRates.get(term.name() + base.name())) * amount;
    }

}
