package com.ignacio.appnoticias.mainModule.adapter

import com.ignacio.appnoticias.classes.Noticias

interface OnClickListener {
    fun onClick(noticia: Noticias)
    fun onLongClick(noticia: Noticias)
}