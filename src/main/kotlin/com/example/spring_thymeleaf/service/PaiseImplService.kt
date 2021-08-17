package com.example.spring_thymeleaf.service

import com.example.spring_thymeleaf.model.Pais
import org.springframework.stereotype.Service

@Service("paiseImplService")
class PaiseImplService : IListaPaises {

    private var listaPaises: List<Pais>? = null

    init {
        this.listaPaises = listOf(
            Pais(1, "MX", "México"),
            Pais(2, "USA", "Estados Unidos"),
            Pais(3, "CA", "Canada"),
            Pais(4, "CH", "China")
        )
    }

    override fun listarPaises(): List<Pais>? {
        return listaPaises
    }

    override fun buscarPorID(id: Int): Pais? {
        for (p in listaPaises!!) {
            if (p.id == id) {
                return p
            }
        }
        return null
    }
}