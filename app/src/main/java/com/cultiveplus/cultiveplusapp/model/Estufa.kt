package com.cultiveplus.cultiveplusapp.model

import java.io.Serializable

data class Estufa(
    val id: Int,
    val nome: String,
    val tipo: Tipo,

    ):Serializable


data class Tipo(
    val id: Int,
    val nome: String,
    val descricao: String

):Serializable
