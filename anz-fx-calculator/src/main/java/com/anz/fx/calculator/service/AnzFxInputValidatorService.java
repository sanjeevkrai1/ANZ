package com.anz.fx.calculator.service;

import com.anz.fx.calculator.model.AnzFxValidationResult;

public interface AnzFxInputValidatorService {
    AnzFxValidationResult validate(String input);
}
