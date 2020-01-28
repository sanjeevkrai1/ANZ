package com.anz.fx.calculator;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

import com.anz.fx.calculator.costants.AnzFxCurrencies;
import com.anz.fx.calculator.service.AnzFxCurrencyFormatterService;
import com.anz.fx.calculator.service.impl.AnzFxCurrencyFormatterServiceImpl;

public class AnzFxFormatterServiceImplTest {
    @Test
    public void testFormatOutputAsPerCurrency(){

        //given
        AnzFxCurrencyFormatterService testClass = new AnzFxCurrencyFormatterServiceImpl();

        //when
        String output = testClass.formatOutputAsPerCurrency("100.00",505.76,AnzFxCurrencies.AUD,AnzFxCurrencies.DKK);

        //then
        assertEquals(output,"AUD 100.00 = DKK 505.76");

    }

    @Test
    public void testFormatOutputForJPY(){

        //given
        AnzFxCurrencyFormatterService testClass = new AnzFxCurrencyFormatterServiceImpl();

        //when
        String output = testClass.formatOutputAsPerCurrency("101.50",10192.76,AnzFxCurrencies.AUD,AnzFxCurrencies.JPY);

        //then
        assertEquals(output,"AUD 101.50 = JPY 10193.0");

    }
}
