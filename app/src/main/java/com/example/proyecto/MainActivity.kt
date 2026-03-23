package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        val etUsuario = findViewById<EditText>(R.id.etUsuario)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnPedidos = findViewById<Button>(R.id.btnPedidos)


        btnLogin.setOnClickListener {
            val usuario = etUsuario.text.toString().trim()
            val password = etPassword.text.toString().trim()
        btnPedidos.setOnClickListener {


            if (usuario == "admin" && password == "1234") {


                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                intent.putExtra("usuario",usuario)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(
                    this,
                    "Usuario o contraseña incorrectos",
                    Toast.LENGTH_SHORT
                ).show()
            }


        }
            val intent = Intent(this, PedidosActivity::class.java)
            startActivity(intent)
        }

    }

}















