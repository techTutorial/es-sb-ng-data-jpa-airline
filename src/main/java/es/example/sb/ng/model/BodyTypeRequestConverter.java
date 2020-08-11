package es.example.sb.ng.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

//below class is not being used, checked by commenting whole class;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
// Request Parameter Converter
public @interface BodyTypeRequestConverter {

}
