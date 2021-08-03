package com.example.spring_thymeleaf.controller

import com.example.spring_thymeleaf.model.Usuario
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import javax.validation.Valid

@Controller
class UsuarioController {

    @GetMapping("/registro")
    fun formularioUsuario(vista: Model): String {
        return "form_usuario"
    }

    @PostMapping("/proceso")
    fun procesoFormUsuario(@Valid usuario: Usuario, resultado: BindingResult, vista: Model): String {
        //El BindingResult toma las validaciones realizadas y aplicadas en el formulario

        if (resultado.hasErrors()) {
            val mapaError: MutableMap<String, String> = hashMapOf()
            resultado.fieldErrors.forEach { error ->
                mapaError[error.field] = "El campo ${error.field} ${error.defaultMessage}"
            }
            vista.addAttribute("error", mapaError)
            return "form_usuario"
        }

        vista.addAttribute("usuario", usuario)
        vista.addAttribute("titulo", "Resultado de la informcion")
        return "proceso_form"
    }

}