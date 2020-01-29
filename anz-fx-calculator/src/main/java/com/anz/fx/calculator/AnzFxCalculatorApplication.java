package com.anz.fx.calculator;

import com.anz.fx.calculator.config.AnzFxCurrencyConverterConfig;
import com.anz.fx.calculator.service.AnzFxCurrencyConvertService;
import com.anz.fx.calculator.service.impl.AnzFxCurrencyConvertServiceImpl;
import com.anz.fx.calculator.service.impl.AnzFxCurrencyFormatterServiceImpl;
import com.anz.fx.calculator.service.impl.AnzFxInputValidatorServiceImpl;
import com.anz.fx.calculator.view.AnzFxCureencyConversionConsole;
/**
 * 
 * @author Sanjeev Rai
 * Main Class to start console based application
 */
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

	
	
	/**
	 * Initializing the FX-Calculator Config
	 * 
	 * @throws Exception
	 */
	public void initFxCalculatorConfig() throws Exception {
        AnzFxCurrencyConverterConfig anzFxCurrencyConverterConfig = new AnzFxCurrencyConverterConfig();
        anzFxCurrencyConvertService = new AnzFxCurrencyConvertServiceImpl(
        		anzFxCurrencyConverterConfig.getCrossCurrencyTable(), anzFxCurrencyConverterConfig.getCurrencyExchangeRate());

    }

	/**
	 * Starting FX calculator
	 */
    public void startFxCalculator() {
        new AnzFxCureencyConversionConsole(anzFxCurrencyConvertService, new AnzFxInputValidatorServiceImpl(), new AnzFxCurrencyFormatterServiceImpl()).currencyConversionOutput();
    }


}
