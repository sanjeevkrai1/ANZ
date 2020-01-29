package com.anz.fx.calculator.service.impl;

import com.anz.fx.calculator.costants.AnzFxCurrencies;
import com.anz.fx.calculator.model.AnzFxValidationResult;
import com.anz.fx.calculator.service.AnzFxInputValidatorService;


/**
 * 
 * @author Sanjeev Rai
 *  AnzFxInputValidatorServiceImpl validate the input enter from console.
 *  
 */
public class AnzFxInputValidatorServiceImpl implements AnzFxInputValidatorService {
	
	/**
	 * validating input 
	 * As per input return the result 
	 * If string is valid then it will return "Success" or it will return "Invalid input"
	 * @return AnzFxValidationResult
	 */
	
    @Override
    public AnzFxValidationResult validate(String input) {
        AnzFxValidationResult result = new AnzFxValidationResult();
        if (input.isEmpty()) {
            result.setMessage("No input entered");
            return result;
        }

        String[] inputToken = input.trim().split("\\s+");
        
        if(inputToken.length < 4 || inputToken.length > 4) {
        	  result.setMessage("Invalid input");
              return result;
        }
        
        if(inputToken.length == 4 && !inputToken[2].equalsIgnoreCase("IN")) {
        	  result.setMessage("Invalid input");
              return result;
        }
        
        if (inputToken.length != 4 && !inputToken[2].equalsIgnoreCase("IN")) {
            result.setMessage("Invalid input");
            return result;
        }

        try {
            AnzFxCurrencies.valueOf(inputToken[0]);
            AnzFxCurrencies.valueOf(inputToken[3]);
        } catch (Exception e) {
            result.setMessage("Unable to find rate for "+inputToken[0]+"/"+inputToken[3]);
            return result;
         }

        try {
            if(Double.parseDouble(inputToken[1]) <= 0d){
                throw new Exception();
            }
        } catch (Exception ex) {
            result.setMessage("Invalid amount entered");
            return result;
        }

        result.setMessage("SUCCESS");

        return result;
    }

}
