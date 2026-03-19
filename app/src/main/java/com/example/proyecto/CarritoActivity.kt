package com.example.proyecto

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CarritoActivity : AppCompatActivity() {


    private lateinit var recyclerCarrito: RecyclerView
    private lateinit var tvTotal: TextView
    private lateinit var btnVaciarCarrito: Button
    private lateinit var CarritoAdapter: CarritoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito)


        recyclerCarrito = findViewById(R.id.recyclerCarrito)
        tvTotal = findViewById(R.id.tvTotal)
        btnVaciarCarrito = findViewById(R.id.btnVaciarCarrito)


        recyclerCarrito.layoutManager = LinearLayoutManager(this)

        CarritoAdapter = CarritoAdapter(CarritoManager.listaCarrito) {
            actualizarTotal()

        }

        recyclerCarrito.adapter = CarritoAdapter

        btnVaciarCarrito.setOnClickListener {
            CarritoManager.vaciarCarrito()
            CarritoAdapter.notifyDataSetChanged()
            actualizarTotal()
            Toast.makeText(this, "Carrito vaciado", Toast.LENGTH_SHORT).show()
        }
        actualizarTotal()

    }
    private fun actualizarTotal() {
        val total = CarritoManager.listaCarrito.sumOf { it.precio }
        tvTotal.text = "Total: $${"%.2f".format(total)}"
    }
}