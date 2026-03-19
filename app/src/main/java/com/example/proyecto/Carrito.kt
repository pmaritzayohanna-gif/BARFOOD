package com.example.proyecto

object Carrito{

    val items = mutableListOf<Suplemento>()

    fun agregar(suplemento: Suplemento) {
        items.add(suplemento)
    }
    fun totalItems(): Int {
        return items.size
    }
}