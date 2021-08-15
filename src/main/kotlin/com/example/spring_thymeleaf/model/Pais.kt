package com.example.spring_thymeleaf.model

class Pais {
    var id: Int? = null
    var codigo: String? = null
    var nombre: String? = null

    constructor(id: Int, codigo: String, nombre: String) {
        this.id = id
        this.codigo = codigo
        this.nombre = nombre
    }

    constructor()
}