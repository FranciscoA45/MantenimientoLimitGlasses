package com.example.limitglasses

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encuentra el botón por su ID
        val btnGoogle = findViewById<AppCompatButton>(R.id.btnGogle)

        // Agrega un OnClickListener al botón
        btnGoogle.setOnClickListener {
            // Crea un Intent para abrir la nueva actividad
            val intent = Intent(this, SelectAccountActivity::class.java)
            startActivity(intent)
        }
    }
}
