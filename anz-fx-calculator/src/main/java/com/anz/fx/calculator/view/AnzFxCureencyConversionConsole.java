package com.anz.fx.calculator.view;

import java.util.Scanner;

import com.anz.fx.calculator.costants.AnzFxCurrencies;
import com.anz.fx.calculator.model.AnzFxCurrencyConversion;
import com.anz.fx.calculator.model.AnzFxValidationResult;
import com.anz.fx.calculator.service.AnzFxCurrencyConvertService;
import com.anz.fx.calculator.service.AnzFxCurrencyFormatterService;
import com.anz.fx.calculator.service.AnzFxInputValidatorService;

public class AnzFxCureencyConversionConsole {
    private AnzFxCurrencyConvertService currencyConverterService;
    private AnzFxInputValidatorService inputValidatorService;
    private AnzFxCurrencyFormatterService outputFormatterService;

    public AnzFxCureencyConversionConsole(AnzFxCurrencyConvertService currencyConverterService, AnzFxInputValidatorService inputValidatorService, AnzFxCurrencyFormatterService outputFormatterService) {
        this.currencyConverterService = currencyConverterService;
        this.inputValidatorService = inputValidatorService;
        this.outputFormatterService = outputFormatterService;
    }

    public void currencyConversionOutput() {
        System.out.println("Enter input in the format \"<ccy1> <amount1> in <ccy2>\"");
        String input = currencyConversionInput();
        while(!input.equals("EXIT")){
            AnzFxValidationResult result = inputValidatorService.validate(input.trim());
            if(result.getMessage().equals("SUCCESS")){
                AnzFxCurrencyConversion model = buildModel(input);
                Double convertedAmount = currencyConverterService.convert(model);
                String output = outputFormatterService.formatOutputAsPerCurrency
                        (model.getAmountInString(),convertedAmount,model.getBase(),model.getTerms());
                printOutput(output);
            } else{
                printError(result.getMessage());
            }
            input = currencyConversionInput();
        }
    }
    @SuppressWarnings("resource")
	private String currencyConversionInput(){
        Scanner in = null;
        if(in == null){
            in = new Scanner(System.in);
        }
        return in.nextLine().trim().toUpperCase();
    }

    private AnzFxCurrencyConversion buildModel(String input){
        String[] inputToken = input.trim().split("\\s+");
        return new AnzFxCurrencyConversion(AnzFxCurrencies.valueOf(inputToken[0]), AnzFxCurrencies.valueOf(inputToken[3]), inputToken[1]);
    }

    private void printError(String errorMessage){
        System.err.println(errorMessage);
    }
    private void printOutput(String output){
        System.out.println(output);
    }
}
