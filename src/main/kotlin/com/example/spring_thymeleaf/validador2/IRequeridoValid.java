package com.example.spring_thymeleaf.validador2;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = Validacor2.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface IRequeridoValid {

    String message() default "Campo Apellido es requerido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
