package com.example.proyecto

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AccesoriosActivity : AppCompatActivity() {

    private lateinit var tvContadorCarrito: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accesorios)

        val rvAccesorios = findViewById<RecyclerView>(R.id.rvAccesorios)
        val btnVerCarrito = findViewById<Button>(R.id.btnVerCarrito)
        tvContadorCarrito = findViewById(R.id.tvContadorCarrito)

        rvAccesorios.layoutManager = LinearLayoutManager(this)

        val accesorios = listOf(
            Accesorio("Correa", 12000.0, R.drawable.logo_tienda_background),
            Accesorio("Juguete", 8000.0, R.drawable.logo_tienda_background),
            Accesorio("Plato", 15000.0, R.drawable.logo_tienda_background),
            Accesorio("cama", 28000.0, R.drawable.logo_tienda_background)



        )
    }
}