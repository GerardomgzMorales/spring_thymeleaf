package com.example.spring_thymeleaf.anotacion_valid

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class ValidacionIndex : ConstraintValidator<IndexRegex, String> {

    override fun isValid(p0: String?, p1: ConstraintValidatorContext?): Boolean {
        //true bien false mal
        val cadena2 = "[\\d]{2}[.][\\d]{3}[.][0-9]{3}[-][a-zñA-ZÑ]"
        if (p0?.matches(Regex(cadena2)) == true) {
            return true
        }
        return false
    }

}