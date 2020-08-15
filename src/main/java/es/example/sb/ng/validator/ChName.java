package es.example.sb.ng.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ChNameValidator.class)
public @interface ChName {

	// Chinese name is provided but it is not present in the list used by ChNameValidator class
    String message() default "Invalid Chinese Name...";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
