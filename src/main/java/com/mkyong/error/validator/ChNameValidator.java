package com.mkyong.error.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class ChNameValidator implements ConstraintValidator<ChName, String> {

    List<String> chNameList = Arrays.asList("吉塔", "乌尔瓦希", "阿尔普纳", "amy");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return chNameList.contains(value);
    }
    
}
