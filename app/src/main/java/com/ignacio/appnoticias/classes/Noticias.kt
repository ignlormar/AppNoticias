package com.ignacio.appnoticias.classes

data class Noticias(
    val id: Long,
    var titular: String,
    var preview: String,
    var fecha: String,
    var imagen: String,
    var url: String
)
