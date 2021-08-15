package com.example.spring_thymeleaf.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import java.beans.PropertyEditorSupport

@Component
class PaiseEditorPropertie : PropertyEditorSupport() {

    @Autowired
    @Qualifier("paiseImplService")
    private var paisServiceLista: IListaPaises? = null

    override fun setAsText(text: String?) {
        if (text.isNullOrEmpty()) {
            this.value = this.paisServiceLista?.buscarPorID(0)
        } else {
            this.value = text?.toInt()?.let { this.paisServiceLista?.buscarPorID(it) }
        }
    }
}