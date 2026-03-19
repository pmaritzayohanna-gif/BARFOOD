package com.example.proyecto

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.PerrosAdapter

class PerrosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perros)

        val recycler = findViewById<RecyclerView>(R.id.recyclerPerros)

        val productos = listOf(
            "Barf Pollo",
            "Barf Res",
            "Snacks Naturales",
            "Huesos Dentales",
            "Comida Premium"
        )
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = PerrosAdapter(productos)

        }
    }
