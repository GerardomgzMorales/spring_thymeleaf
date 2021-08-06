package com.example.spring_thymeleaf.validador2

import org.springframework.util.StringUtils
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class Validacor2 : ConstraintValidator<IRequeridoValid?, String?> {

    override fun isValid(s: String?, constraintValidatorContext: ConstraintValidatorContext): Boolean {
        return !(s == null || !StringUtils.hasText(s))
    }
}