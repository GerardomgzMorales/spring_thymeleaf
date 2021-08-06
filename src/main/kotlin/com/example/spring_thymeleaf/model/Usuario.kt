package com.example.spring_thymeleaf.model

import com.example.spring_thymeleaf.anotacion_valid.IndexRegex
import com.example.spring_thymeleaf.validador2.IRequeridoValid
import javax.validation.constraints.*


class Usuario {

    //@NotEmpty
    // @Pattern()
    @IndexRegex
    var id: String? = null

    //@NotEmpty
    var nombreUsuario: String? = null

    @IRequeridoValid
    var apellidoUsuario: String? = null

    @NotEmpty
    @Email
    var correoUsuario: String? = null

    @NotEmpty
    @Size(min = 3, max = 12)
    var contrasenia: String? = null

    @NotNull
    var edad: Int? = null

    constructor()

    constructor(
        nombreUsuario: String?,
        apellidoUsuario: String?,
        correoUsuario: String?,
        contrasenia: String?,
        edad: Int?
    ) {
        this.nombreUsuario = nombreUsuario
        this.apellidoUsuario = apellidoUsuario
        this.correoUsuario = correoUsuario
        this.contrasenia = contrasenia
        this.edad = edad
    }
}