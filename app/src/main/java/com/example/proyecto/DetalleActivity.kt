package com.example.proyecto

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imgDetalle = findViewById<ImageView>(R.id.imgDetalle)
        val tvNombre = findViewById<TextView>(R.id.tvDetalleNombre)
        val tvPrecio = findViewById<TextView>(R.id.tvDetallePrecio)
        val btnAgregarCarrito = findViewById<Button>(R.id.btnAgregarCarrito)
        val btnVerCarrito = findViewById<Button>(R.id.btnVerCarrito)

        val nombre = intent.getStringExtra("nombre") ?: "Sin nombre"
        val precio = intent.getDoubleExtra("precio", 0.0)
        val imagen = intent.getIntExtra("imagenResId", 0)


        tvNombre.text = nombre
        tvPrecio.text = "$${precio.toInt()}"

        btnVerCarrito.text = "Ver carrito (${CarritoManager.obtenerCantidad()})"

        btnAgregarCarrito.setOnClickListener {
            val producto = Suplemento(nombre, precio, imagen)
            CarritoManager.agregarProducto(producto)

            btnVerCarrito.text = "Ver carrito (${CarritoManager.obtenerCantidad()})"

            Toast.makeText(this, "Producto agregado al carrito", Toast.LENGTH_SHORT).show()
        }
        btnVerCarrito.setOnClickListener {
            startActivity(Intent(this, CarritoActivity::class.java))
        }
    }

}
