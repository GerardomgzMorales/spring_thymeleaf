package com.example.spring_thymeleaf.model

import org.springframework.stereotype.Component
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Component
class Usuario {

    final var id: Long? = null

    @NotEmpty
    final var nombreUsuario: String? = null

    @NotEmpty
    final var apellidoUsuario: String? = null

    @NotEmpty
    final var correoUsuario: String? = null

    @NotEmpty
    final var contrasenia: String? = null

    @NotNull
    final var edad: Int? = null

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