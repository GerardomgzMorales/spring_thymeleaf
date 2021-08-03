package com.example.spring_thymeleaf.model

import org.springframework.stereotype.Component
import javax.validation.constraints.NotEmpty

@Component
class Usuario {
    @NotEmpty
    final var nombreUsuario: String? = null

    @NotEmpty
    final var apellidoUsuario: String? = null

    @NotEmpty
    final var correoUsuario: String? = null

    @NotEmpty
    final var contrasenia: String? = null

    constructor()

    constructor(nombreUsuario: String?, apellidoUsuario: String?, correoUsuario: String?, contrasenia: String?) {
        this.nombreUsuario = nombreUsuario
        this.apellidoUsuario = apellidoUsuario
        this.correoUsuario = correoUsuario
        this.contrasenia = contrasenia
    }
}