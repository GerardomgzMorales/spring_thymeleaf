package com.example.spring_thymeleaf.controller

import com.example.spring_thymeleaf.model.Usuario
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.ValidationUtils
import org.springframework.validation.Validator

@Component
class Validador : Validator {

    override fun supports(p0: Class<*>): Boolean = Usuario::class.java.isAssignableFrom(p0)

    override fun validate(p0: Any, p1: Errors) {
        // val usuarioTarget = p0 as Usuario

        ValidationUtils.rejectIfEmptyOrWhitespace(p1, "nombreUsuario", "NotNull.usuario.nombreUsuario")

        /* if (usuarioTarget.id?.matches(Regex("[\\d]{2}[.][\\d]{3}[.][0-9]{3}[-][a-zñA-ZÑ]{1}")) == false) {
             p1.rejectValue("id", "Pattern.usuario.id")
         }*/

    }


}