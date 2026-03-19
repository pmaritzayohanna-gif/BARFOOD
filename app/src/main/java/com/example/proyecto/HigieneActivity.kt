package com.example.proyecto

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HigieneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_higiene)

        val recyclerHigiene = findViewById<RecyclerView>(R.id.recyclerHigiene)

        val listaProductos = listOf(
          Suplemento("Shampoo clorhexidina",25000.0,0),
          Suplemento("Jabon anticeptico ",22000.0,0),
          Suplemento("Cepillo dental",12000.0,0),
          Suplemento("Toallas humedas",15000.0,0),
          Suplemento("Colonia canina",22000.0, 0),
          Suplemento("Cortaunas",17000.0, 0)
        )
        recyclerHigiene.layoutManager = LinearLayoutManager(this)
        recyclerHigiene.adapter = ProductoAdapter(listaProductos)

    }
}