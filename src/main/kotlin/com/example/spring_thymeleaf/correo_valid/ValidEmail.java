package com.example.spring_thymeleaf.correo_valid;

import com.example.spring_thymeleaf.validador2.Validacor2;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailValidClass.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidEmail {

    String message() default "Este correo no cumple con la estructura";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
