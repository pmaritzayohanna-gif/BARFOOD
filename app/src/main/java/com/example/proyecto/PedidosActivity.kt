package com.example.proyecto

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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
        val etNombrePedido = findViewById<EditText>(R.id.etNombrePedido)
        val etCantidadPedido = findViewById<EditText>(R.id.etCantidadPedido)
        val btnAgregarPedido = findViewById<Button>(R.id.btnAgregarPedido)

        val listaPedidos = mutableListOf(
            Pedido("Comida barf", "x5"),
            Pedido("Snack dental", "x3"),
            Pedido("Alimento humedo", "x5"),
            Pedido("Cuido premium piel", "x3")
        )

        val adapter = PedidoAdapter(listaPedidos) { position ->
            listaPedidos.removeAt(position)
            recyclerPedidos.adapter?.notifyItemRemoved(position)

        }

        recyclerPedidos.layoutManager = LinearLayoutManager(this)
        recyclerPedidos.adapter = adapter

        btnAgregarPedido.setOnClickListener {
            val nombre = etNombrePedido.text.toString().trim()
            val cantidad = etCantidadPedido.text.toString().trim()

            if (nombre.isEmpty() || cantidad.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()

            } else {
               listaPedidos.add(Pedido(nombre, cantidad))
                adapter.notifyItemInserted(listaPedidos.size - 1)
                etNombrePedido.text.clear()
                etCantidadPedido.text.clear()
            }
        }
    }
}