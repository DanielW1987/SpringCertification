package com.wagner.forms.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MustStartsWithConstraintValidator implements ConstraintValidator<MustStartsWith, String> {

	private String necessaryPrefix;
	
	@Override
	public void initialize(MustStartsWith mustStartWith) {
		necessaryPrefix = mustStartWith.value().toLowerCase();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean validationResult = false;
		
		if (value != null && value.toLowerCase().startsWith(necessaryPrefix)) {
			validationResult = true;
		}
		
		return validationResult;
	}

	
	
}
