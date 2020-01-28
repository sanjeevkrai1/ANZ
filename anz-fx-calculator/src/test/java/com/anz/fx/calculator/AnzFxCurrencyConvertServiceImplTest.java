package com.anz.fx.calculator;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.anz.fx.calculator.config.AnzFxCrossCurrencyTableBuilder;
import com.anz.fx.calculator.costants.AnzFxCurrencies;
import com.anz.fx.calculator.model.AnzFxCurrencyConversion;
import com.anz.fx.calculator.service.AnzFxCurrencyConvertService;
import com.anz.fx.calculator.service.impl.AnzFxCurrencyConvertServiceImpl;


public class AnzFxCurrencyConvertServiceImplTest {

    @Test
    public void testConvert_AUDToUSD(){
        //given
        AnzFxCurrencyConversion conversionModel = mock(AnzFxCurrencyConversion.class);
        when(conversionModel.getBase()).thenReturn(AnzFxCurrencies.AUD);
        when(conversionModel.getTerms()).thenReturn(AnzFxCurrencies.USD);
        when(conversionModel.getAmount()).thenReturn(100.00d);

        AnzFxCurrencyConvertService testClass = new AnzFxCurrencyConvertServiceImpl(AnzFxCrossCurrencyTableBuilder.build(),getCurrencyExchangeRate());

        //when
        Double output = testClass.convert(conversionModel);

        //then
        assertEquals(output,83.71);
    }

    @Test
    public void testConvert_WithSameCurrency_AUDToAUD(){
        //given
        AnzFxCurrencyConversion conversionModel = mock(AnzFxCurrencyConversion.class);
        when(conversionModel.getBase()).thenReturn(AnzFxCurrencies.AUD);
        when(conversionModel.getTerms()).thenReturn(AnzFxCurrencies.AUD);
        when(conversionModel.getAmount()).thenReturn(100.00d);

        AnzFxCurrencyConvertService testClass = new AnzFxCurrencyConvertServiceImpl(AnzFxCrossCurrencyTableBuilder.build(),getCurrencyExchangeRate());

        //when
        Double output = testClass.convert(conversionModel);

        //then
        assertEquals(output,100.00d);
    }

    @Test
    public void testConvert_AUDToDKK(){
        //given
        AnzFxCurrencyConversion conversionModel = mock(AnzFxCurrencyConversion.class);
        when(conversionModel.getBase()).thenReturn(AnzFxCurrencies.AUD);
        when(conversionModel.getTerms()).thenReturn(AnzFxCurrencies.DKK);
        when(conversionModel.getAmount()).thenReturn(100.00d);

        AnzFxCurrencyConvertService testClass = new AnzFxCurrencyConvertServiceImpl(AnzFxCrossCurrencyTableBuilder.build(),getCurrencyExchangeRate());

        //when
        Double output = testClass.convert(conversionModel);

        //then
        DecimalFormat df = new DecimalFormat(".##");
        assertEquals(df.format(output),String.valueOf(505.76d));
    }


    @Test
    public void testConvert_JPYToUSD(){
        //given
        AnzFxCurrencyConversion conversionModel = mock(AnzFxCurrencyConversion.class);
        when(conversionModel.getBase()).thenReturn(AnzFxCurrencies.JPY);
        when(conversionModel.getTerms()).thenReturn(AnzFxCurrencies.USD);
        when(conversionModel.getAmount()).thenReturn(100.00d);

        AnzFxCurrencyConvertService testClass = new AnzFxCurrencyConvertServiceImpl(AnzFxCrossCurrencyTableBuilder.build(),getCurrencyExchangeRate());

        //when
        Double output = testClass.convert(conversionModel);

        //then
        DecimalFormat df = new DecimalFormat("0.##");
        assertEquals(df.format(output),String.valueOf(.83d));
    }

    @Test
    public void testConvert_AUDToJPY(){
        //given
        AnzFxCurrencyConversion conversionModel = mock(AnzFxCurrencyConversion.class);
        when(conversionModel.getBase()).thenReturn(AnzFxCurrencies.AUD);
        when(conversionModel.getTerms()).thenReturn(AnzFxCurrencies.JPY);
        when(conversionModel.getAmount()).thenReturn(1d);

        AnzFxCurrencyConvertService testClass = new AnzFxCurrencyConvertServiceImpl(AnzFxCrossCurrencyTableBuilder.build(),getCurrencyExchangeRate());

        //when
        int output = (int)testClass.convert(conversionModel);

        //then
        assertEquals(output,100);
    }

    public Map<String, Double> getCurrencyExchangeRate(){
        Map<String,Double> exchangeMap = new HashMap<>();
        exchangeMap.put("AUDUSD",0.8371);
        exchangeMap.put("CADUSD",0.8711);
        exchangeMap.put("USDCNY",6.1715);
        exchangeMap.put("EURUSD",1.2315);
        exchangeMap.put("GBPUSD",1.5683);
        exchangeMap.put("NZDUSD",0.7750);
        exchangeMap.put("USDJPY",119.95);
        exchangeMap.put("EURCZK",27.6028);
        exchangeMap.put("EURDKK",7.4405);
        exchangeMap.put("EURNOK",8.6651);
        return exchangeMap;
    }
}
