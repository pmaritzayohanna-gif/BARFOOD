package com.example.proyecto

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.widget.Button
import android.widget.TextView

class SuplementoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_suplemento)

        val btnVerCarrito = findViewById<Button>(R.id.btnVerCarrito)
        btnVerCarrito.setOnClickListener {
        startActivity(Intent(this, CarritoActivity::class.java))
        }

        val tvContador = findViewById<TextView>(R.id.tvContadorCarrito)

        fun actualizarContador() {
            tvContador.text = "Carrito (${Carrito.items.size})"
        }
        actualizarContador()

        val recycler = findViewById<RecyclerView>(R.id.rvSuplemento)
            recycler.layoutManager = LinearLayoutManager(this)

        val listaSuplemento = listOf(
            Suplemento("Proteìna Whey", 120000.0, R.drawable.logo_tienda_background),
            Suplemento("Creatina", 80000.0, R.drawable.logo_tienda_background),
            Suplemento("BCAA", 60000.0, R.drawable.logo_tienda_background),
            Suplemento("Pre-entreno", 95000.0, R.drawable.logo_tienda_background)

        )
        val adapter = SuplementoAdapter(listaSuplemento) { suplemento ->
            Carrito.agregar(suplemento)
            actualizarContador()
            Toast.makeText(this, "${suplemento.nombre} agregado al carrito", Toast.LENGTH_SHORT).show()
        }

        recycler.adapter = adapter


    }
}