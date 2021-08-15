package com.example.spring_thymeleaf.model

import com.example.spring_thymeleaf.anotacion_valid.IndexRegex
import com.example.spring_thymeleaf.correo_valid.ValidEmail
import com.example.spring_thymeleaf.validador2.IRequeridoValid
import java.util.*
import javax.validation.constraints.*


class Usuario() {

    //@NotEmpty
    // @Pattern()
    @IndexRegex
    var id: String? = null

    //@NotEmpty
    var nombreUsuario: String? = null

    @IRequeridoValid
    var apellidoUsuario: String? = null

    @NotEmpty
    // @Email
    @ValidEmail
    var correoUsuario: String? = null

    @NotEmpty
    @Size(min = 3, max = 12)
    var contrasenia: String? = null

    @NotNull
    var edad: Int? = null

    @NotNull
    //@Past  // fehcas en el pasado
    // @Future // fechas en el futuro
    // @DateTimeFormat(pattern = "yyyy-MM-dd")
    var fechaNacimientoo: Date? = null

    @NotNull
    var pais: Pais? = null
    //var pais: String? = null

}