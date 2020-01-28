package com.anz.fx.calculator;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

import com.anz.fx.calculator.model.AnzFxValidationResult;
import com.anz.fx.calculator.service.AnzFxInputValidatorService;
import com.anz.fx.calculator.service.impl.AnzFxInputValidatorServiceImpl;

public class AnzFxInputValidatorServiceImplTest {
    @Test
    public void testValidate_NoInput(){
        //given
        AnzFxInputValidatorService testClass = new AnzFxInputValidatorServiceImpl();

        //when
        AnzFxValidationResult result = testClass.validate("");

        //then
        assertEquals(result.getMessage(),"No input entered");
    }

    @Test
    public void testValidate_InvalidInput(){
        //given
        AnzFxInputValidatorService testClass = new AnzFxInputValidatorServiceImpl();

        //when
        AnzFxValidationResult result = testClass.validate("ABC 123 234");

        //then
        assertEquals(result.getMessage(),"Invalid input");
    }

    @Test
    public void testValidate_InvalidCurrency(){
        //given
        AnzFxInputValidatorService testClass = new AnzFxInputValidatorServiceImpl();

        //when
        AnzFxValidationResult result = testClass.validate("KRW 1000.00 in FJD");

        //then
        assertEquals(result.getMessage(),"Unable to find rate for KRW/FJD");
    }

    @Test
    public void testValidate_InvalidAmount(){
        //given
        AnzFxInputValidatorService testClass = new AnzFxInputValidatorServiceImpl();

        //when
        AnzFxValidationResult result = testClass.validate("AUD 00.00 in USD");

        //then
        assertEquals(result.getMessage(),"Invalid amount entered");
    }

    @Test
    public void testValidate_NegativedAmount(){
        //given
        AnzFxInputValidatorService testClass = new AnzFxInputValidatorServiceImpl();

        //when
        AnzFxValidationResult result = testClass.validate("AUD -100.00 in USD");

        //then
        assertEquals(result.getMessage(),"Invalid amount entered");
    }
}


