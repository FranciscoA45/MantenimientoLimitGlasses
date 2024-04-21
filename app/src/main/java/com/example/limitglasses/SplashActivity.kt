package com.example.limitglasses

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide() // Verifica si supportActionBar es nulo antes de ocultarlo
        val i = Intent(this@SplashActivity, Register::class.java)
        Handler().postDelayed({
            startActivity(i)
            finish()
        }, 3000)
    }
}
