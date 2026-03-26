package com.example.proyecto

object CarritoManager {

    val listaCarrito : MutableList<Suplemento> = mutableListOf()

    fun agregarProducto(producto: Suplemento) {
        listaCarrito.add(producto)
    }

    fun obtenerProductos(): List<Suplemento> {
        return listaCarrito

    }

    fun obtenerCantidad(): Int {
        return listaCarrito.size

    }
    fun vaciarCarrito() {
        listaCarrito.clear()
    }

}
