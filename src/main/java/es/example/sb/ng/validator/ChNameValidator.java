package es.example.sb.ng.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class ChNameValidator implements ConstraintValidator<ChName, String> {

    List<String> chNameList = Arrays.asList("CH-01", "CH-02", "CH-03", "CH-04", "CH吉塔", "CH乌尔瓦希", "CH阿尔普纳", "CHAmit");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
    	// use equalsIgnoreCase() method for case-insensitive > Pending
        return chNameList.contains(value);
    }
    
}
