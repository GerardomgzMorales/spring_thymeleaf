package com.example.spring_thymeleaf.controller

import com.example.spring_thymeleaf.model.Pais
import com.example.spring_thymeleaf.model.Usuario
import com.example.spring_thymeleaf.service.IListaPaises
import com.example.spring_thymeleaf.service.PaiseEditorPropertie
import com.example.spring_thymeleaf.validation.MayusKey
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.propertyeditors.CustomDateEditor
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.support.SessionStatus
import java.text.SimpleDateFormat
import java.util.*
import javax.validation.Valid

@Controller
@SessionAttributes("usuario")
class UsuarioController {
    // @SessionAttributes("usuario") se guarda en una sesion y se mantiene Vivos entre sesiones

    @Autowired
    val validador: Validador? = null

    @Autowired
    @Qualifier("paiseImplService")
    val servicePais: IListaPaises? = null

    @Autowired
    @Qualifier("paiseEditorPropertie")
    var propertiesPais: PaiseEditorPropertie? = null

    @InitBinder
    fun inicializador(webBinder: WebDataBinder) {
        // Se agrega esta funcion ya que podemos automatizar la validacion que hace el formulario
        //gracias a la anotacion @Valid desde la funcion procesoFormUsuario

        // webBinder.validator = validador  //al realizar este tipo de validacion solo se considera la validacion creada desde la clase validacion

        webBinder.addValidators(validador) // al realizar este tipo de validacion se contempla la validacion de todos los metodos ya sea por anotaciones o por las clases de validacion

        val formatoFecha = SimpleDateFormat("yyyy-MM-dd")
        formatoFecha.isLenient = false //false si el analizador de patron No es estricto y true si debe ser estricto
        webBinder.registerCustomEditor(Date::class.java, CustomDateEditor(formatoFecha, false))


        webBinder.registerCustomEditor(String::class.java, "nombreUsuario", MayusKey())  /*Este funcion toma todo los string y los combierte a mayusculas es parte de la validador de campos y se esta
        registrando este validado en el formulario*/

        webBinder.registerCustomEditor(String::class.java, "apellidoUsuario", MayusKey())  /*Este funcion toma todo los string y los combierte a mayusculas es parte de la validador de campos y se esta
        registrando este validado en el formulario.
        los parametros de esta funcion son 1) el tipo de dato a validad, 2) es el nombre del campo del formulario que se debe validar y 3) es la clase que hace la validacion*/
        webBinder.registerCustomEditor(String::class.java, "id", MayusKey())

        propertiesPais?.let { webBinder.registerCustomEditor(Pais::class.java, "pais", it) }
    }


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

    @ModelAttribute("lista_pais")
    fun listaPaises(): List<String> {
        return listOf(
            "México",
            "USA",
            "Canada",
            "España",
            "Perú",
            "Argentina",
            "Uruguay",
            "China",
            "Palestina",
            "Qatar",
            "Somalia",
            "Paraguay"
        )
    }

    @ModelAttribute("paisesObj")
    fun listaObjPais(): List<Pais>? {

        /* fun listaObjPais(): List<Pais> {
             return listOf(
                 Pais(1, "MX", "México"),
                 Pais(2, "USA", "Estados Unidos"),
                 Pais(3, "CA", "Canada"),
                 Pais(4, "CH", "China")
             )
         }*/
        return this.servicePais?.listarPaises()
    }
}