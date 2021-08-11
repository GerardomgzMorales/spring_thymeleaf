package com.example.spring_thymeleaf.validation

import java.beans.PropertyEditorSupport

class MayusKey : PropertyEditorSupport() {

    /*
    * la clase PropertyEditorSupport, esta da lo necesario para poder tener una funcion de laidacion de campos, la cual con la funcion
    * setAsText toma el texto que se ingresa en el formulario desde la vista y valida que si se cumple con los respectivos valores
    * acorde como el campo se esta declrando
    * */

    override fun setAsText(text: String?) {
        value = text?.trim()!!.uppercase()
    }


}