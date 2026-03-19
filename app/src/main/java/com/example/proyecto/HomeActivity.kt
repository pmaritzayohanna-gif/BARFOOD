package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView
import com.google.android.material.imageview.ShapeableImageView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val tvTituloHome = findViewById<TextView>(R.id.tvTituloHome)
        val tvBienvenido = findViewById<TextView>(R.id.tvBienvenido)
        val imgUsuario = findViewById<ShapeableImageView>(R.id.imgUsuario)
        val tvMensaje = findViewById<TextView>(R.id.tvMensaje)
        val btnCerrarSesion = findViewById<Button>(R.id.btnCerrarSesion)
        val btnCarrito = findViewById<Button>(R.id.btnCarrito)

        val cardAlimento = findViewById<MaterialCardView>(R.id.cardCategoriaAlimento)
        val cardHuesos = findViewById<MaterialCardView>(R.id.cardCategoriaHuesos)
        val cardSuplemento = findViewById<MaterialCardView>(R.id.cardCategoriaSuplemento)
        val cardHigiene = findViewById<MaterialCardView>(R.id.cardCategoriaHigiene)
        val btnCarritoTop = findViewById<android.widget.ImageButton>(R.id.btnCarritoTop)

        val usuario = intent.getStringExtra("usuario")
        tvBienvenido.text = "Bienvenido${if (usuario != null) ", $usuario" else ""}"

        cardAlimento.setOnClickListener {
            startActivity(Intent(this, AlimentoActivity::class.java))

        }
        cardHuesos.setOnClickListener {
            startActivity(Intent(this, HuesosActivity::class.java))
        }
        cardSuplemento.setOnClickListener {
            startActivity(Intent(this, SuplementoActivity::class.java))
        }
        cardHigiene.setOnClickListener {
            startActivity(Intent(this, HigieneActivity::class.java))
        }
        btnCerrarSesion.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()

            btnCarritoTop.setOnClickListener {
                startActivity(Intent(this, CarritoActivity::class.java))
            }
        }
        btnCarrito.setOnClickListener {
            startActivity(Intent(this, CarritoActivity::class.java))

        }


    }


}













