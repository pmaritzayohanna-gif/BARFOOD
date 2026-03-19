package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HuesosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_huesos)

        val recycler = findViewById<RecyclerView>(R.id.rvHuesos)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)

        val listaHuesos = listOf(
            Suplemento("Hueso prensado", 18000.0, R.drawable.ic_huesorelleno),
            Suplemento("Hueso de res", 25000.0, R.drawable.ic_huesores),
            Suplemento("Hueso relleno", 22000.0, R.drawable.ic_huesoprensado1),
            Suplemento("Snack dental", 12000.0, R.drawable.ic_suplementoperro)

        )

        recycler.adapter = SuplementoAdapter(listaHuesos) { hueso ->
            val intent = Intent(this, DetalleActivity::class.java).apply {
                putExtra("nombre", hueso.nombre)
                putExtra("precio", hueso.precio)
                putExtra("imagenResId", hueso.imagenResId)
            }
            startActivity(intent)
        }

    }
}