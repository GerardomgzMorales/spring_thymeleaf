package com.example.spring_thymeleaf.service

import com.example.spring_thymeleaf.model.Pais

interface IListaPaises {
    fun listarPaises(): List<Pais>?
    fun buscarPorID(id: Int): Pais?
}