package com.anz.fx.calculator;

import com.anz.fx.calculator.config.AnzFxCurrencyConverterConfig;
import com.anz.fx.calculator.service.AnzFxCurrencyConvertService;
import com.anz.fx.calculator.service.impl.AnzFxCurrencyConvertServiceImpl;
import com.anz.fx.calculator.service.impl.AnzFxCurrencyFormatterServiceImpl;
import com.anz.fx.calculator.service.impl.AnzFxInputValidatorServiceImpl;
import com.anz.fx.calculator.view.AnzFxCureencyConversionConsole;

public class AnzFxCalculatorApplication {

	private AnzFxCurrencyConvertService anzFxCurrencyConvertService;
	
	public static void main(String[] args) {
		
		AnzFxCalculatorApplication anzFxCalculatorApplication = new AnzFxCalculatorApplication();
	        try {
	        	anzFxCalculatorApplication.initFxCalculatorConfig();
			} catch (Exception e) {
				e.printStackTrace();
			}
	        anzFxCalculatorApplication.startFxCalculator();
	}

	
	
	public void initFxCalculatorConfig() throws Exception {
        AnzFxCurrencyConverterConfig anzFxCurrencyConverterConfig = new AnzFxCurrencyConverterConfig();
        anzFxCurrencyConvertService = new AnzFxCurrencyConvertServiceImpl(
        		anzFxCurrencyConverterConfig.getCrossCurrencyTable(), anzFxCurrencyConverterConfig.getCurrencyExchangeRate());

    }

    public void startFxCalculator() {
        new AnzFxCureencyConversionConsole(anzFxCurrencyConvertService, new AnzFxInputValidatorServiceImpl(), new AnzFxCurrencyFormatterServiceImpl()).currencyConversionOutput();
    }


}
