package com.example.spring_thymeleaf.correo_valid

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class EmailValidClass : ConstraintValidator<ValidEmail, String> {
    override fun isValid(p0: String?, p1: ConstraintValidatorContext?): Boolean {


        val cadena2 =
            "^[A-Za-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[A-Za-z0-9!#\$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\.)+[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\$"
        if (p0?.matches(Regex(cadena2)) == true) {
            return true
        }
        return false
    }


}