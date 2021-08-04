package com.example.spring_thymeleaf.model

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


class Usuario {

    var id: Long? = null

    @NotEmpty
    var nombreUsuario: String? = null

    @NotEmpty
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