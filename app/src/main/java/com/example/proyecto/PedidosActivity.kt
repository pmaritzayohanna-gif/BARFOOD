package com.example.proyecto

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PedidosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pedidos)

    val recyclerPedidos = findViewById<RecyclerView>(R.id.recyclerPedidos)

        val listaPedidos = listOf(
            Pedido("Comida barf", "x5"),
            Pedido("Snack dental", "x3"),
            Pedido("Alimento humedo", "x5"),
            Pedido("Cuido premium piel", "x3")
        )

        recyclerPedidos.layoutManager = LinearLayoutManager(this)
        recyclerPedidos.adapter = PedidoAdapter(listaPedidos)
    }
}