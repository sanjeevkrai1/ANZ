package com.anz.fx.calculator.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.anz.fx.calculator.costants.AnzFxCurrencies;
import com.anz.fx.calculator.costants.AnzFxCurrencyPrecisionFormat;
import com.anz.fx.calculator.service.AnzFxCurrencyFormatterService;

/**
 * 
 * @author Sanjeev Rai
 * 
 * AnzFxCurrencyFormatterServiceImpl for formatting the out as per currency
 *
 */
public class AnzFxCurrencyFormatterServiceImpl implements AnzFxCurrencyFormatterService {
	
	/**
	 * Format out of As per currency
	 * @return String
	 */
	
    @Override
    public String formatOutputAsPerCurrency(String actualAmount, Double convertedAmount, AnzFxCurrencies ccy1, AnzFxCurrencies ccy2) {
        convertedAmount = (new BigDecimal(convertedAmount).setScale(AnzFxCurrencyPrecisionFormat.valueOf(ccy2.name()).precision, RoundingMode.HALF_EVEN)).doubleValue();
        return ccy1 + " " + actualAmount + " = " + ccy2 + " " + convertedAmount;
    }
}
