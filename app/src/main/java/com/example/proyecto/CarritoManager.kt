package com.example.proyecto

object CarritoManager {

    private val listaCarrito = mutableListOf<Suplemento>()

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
