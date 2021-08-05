package com.example.spring_thymeleaf.controller

import com.example.spring_thymeleaf.model.Usuario
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.SessionAttributes
import org.springframework.web.bind.support.SessionStatus
import javax.validation.Valid

@Controller
@SessionAttributes("usuario")
class UsuarioController {

    @Autowired
    val validador: Validador? = null

    @InitBinder
    fun inicializador(webBinder: WebDataBinder) {
        // Se agrega esta funcion ya que podemos automatizar la validacion que hace el formulario
        //gracias a la anotacion @Valid desde la funcion procesoFormUsuario

        // webBinder.validator = validador  //al realizar este tipo de validacion solo se considera la validacion creada desde la clase validacion

        webBinder.addValidators(validador) // al realizar este tipo de validacion se contempla la validacion de todos los metodos ya sea por anotaciones o por las clases de validacion
    }

    // @SessionAttributes("usuario") se guarda en una sesion y se mantiene Vivos entre sesiones

    @GetMapping("", "/", "/registro")
    fun formularioUsuario(vista: Model): String {
        val usuario = Usuario()
        usuario.nombreUsuario = "Israel"
        usuario.apellidoUsuario = "Morales ññÑíáóú"
        usuario.edad = 22
        usuario.id = "22.222.985-ñ"
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

        //validador?.validate(usuario, resultado)  // Esta linea pasa el objeto usuario y resultado para que sena validadas en la clase validacion


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