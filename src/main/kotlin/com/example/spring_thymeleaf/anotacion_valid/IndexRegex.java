package com.example.spring_thymeleaf.anotacion_valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidacionIndex.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface IndexRegex {

    String message() default "El formato del ID no es Valido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
