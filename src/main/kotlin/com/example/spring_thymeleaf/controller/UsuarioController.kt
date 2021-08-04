package com.example.spring_thymeleaf.controller

import com.example.spring_thymeleaf.model.Usuario
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.SessionAttributes
import org.springframework.web.bind.support.SessionStatus
import javax.validation.Valid

@Controller
@SessionAttributes("usuario")
class UsuarioController {

    // @SessionAttributes("usuario") se guarda en una sesion y se mantiene Vivos entre sesiones

    @GetMapping("", "/", "/registro")
    fun formularioUsuario(vista: Model): String {
        val usuario = Usuario()
        usuario.nombreUsuario = "Israel Morales ññÑíáóú"
        usuario.edad = 22
        usuario.id = 233_323_349
        vista.addAttribute("usuario", usuario)
        return "form_usuario"
    }

    @PostMapping("/proceso")
    fun procesoFormUsuario(
        @Valid usuario: Usuario,
        resultado: BindingResult,
        vista: Model,
        status: SessionStatus
    ): String {
        //El BindingResult toma las validaciones realizadas y aplicadas en el formulario

        if (resultado.hasErrors()) {
            /*val mapaError: MutableMap<String, String> = hashMapOf()
            resultado.fieldErrors.forEach { error ->
                mapaError[error.field] = "El campo ${error.field} ${error.defaultMessage}"
            }
            vista.addAttribute("error", mapaError)
            //se comneta este codigfo con el fin de realizar esta validacion de error desde
            // la parte del formulario html llamado form_usuario
            */
            return "form_usuario"
        }

        vista.addAttribute("usuario", usuario)
        vista.addAttribute("titulo", "Resultado de la informcion")
        status.setComplete() //Se elimina la seccion levantada en para esta peticion
        //la session levantada es @SessionAttributes("usuario") creada desde la clase controller
        return "proceso_form"
    }

}