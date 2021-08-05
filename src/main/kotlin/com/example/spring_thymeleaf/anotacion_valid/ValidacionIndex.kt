package com.example.spring_thymeleaf.anotacion_valid

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class ValidacionIndex : ConstraintValidator<IndexRegex, String> {

    override fun isValid(p0: String?, p1: ConstraintValidatorContext?): Boolean {
        //true bien false mal
        if (p0?.matches(Regex("[\\d]{2}[.][\\d]{3}[.][0-9]{3}[-][a-zñA-ZÑ]")) == true) {
            return true
        }
        return false
    }

}