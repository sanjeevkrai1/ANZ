package com.anz.fx.calculator.config;

import java.io.File;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 
 * @author Sanjeev Rai
 * Represents exchanges rates from currency_exchange_rates.txt
 *  
 */
public class AnzFxCurrencyConverterConfig {

	/**
	 *  Build In order to help with the conversion, the following "cross-via" matrix may help.
	 *  "Base" currencies are down the left, "terms" currencies across the top.
	 * @return String [][]
	 */
    public String[][] getCrossCurrencyTable() {
        return AnzFxCrossCurrencyTableBuilder.build();
    }

    /**
     * Currency Exchange rate 
     * @return Map<String , Double>
     * @throws Exception
     */
    public Map<String, Double> getCurrencyExchangeRate() throws Exception {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        
        File file = new File(URLDecoder.decode(classLoader.getResource("currency_exchange_rates.txt").getFile()));

        Map<String, Double> currencyExchangeRate = new HashMap<>();
        try (Stream<String> stream = Files.lines(Paths.get(file.getPath()))) {
            stream.map(s -> s.split("=")).forEach(arr ->
                    currencyExchangeRate.put(arr[0], Double.parseDouble(arr[1]))
            );
            return currencyExchangeRate;
        }
    }

}
