package com.example.spring_thymeleaf.validador2

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class Validacor2 : ConstraintValidator<IRequeridoValid?, String?> {

    override fun isValid(s: String?, constraintValidatorContext: ConstraintValidatorContext): Boolean {
        return if (s == null || s.isEmpty() || s.isBlank()) {
            false
        } else false
    }


}