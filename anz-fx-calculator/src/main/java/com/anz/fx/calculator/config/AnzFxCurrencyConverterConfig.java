package com.anz.fx.calculator.config;

import java.io.File;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class AnzFxCurrencyConverterConfig {

    public String[][] getCrossCurrencyTable() {
        return AnzFxCrossCurrencyTableBuilder.build();
    }

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
