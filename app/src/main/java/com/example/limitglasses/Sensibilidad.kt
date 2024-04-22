package com.example.limitglasses

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Sensibilidad : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensibilidad)

        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout2)
        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(drawerToggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)


        val seekBar = findViewById<SeekBar>(R.id.seekbar)
        val textViewSeekBarValue = findViewById<TextView>(R.id.textViewSeekBarValue)


        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                textViewSeekBarValue.text = "Distancia de detección(metros): $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // No necesitamos hacer nada en este método
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // No necesitamos hacer nada en este método
            }
        })

        // Boton guardar cambios
        val guardarButton = findViewById<Button>(R.id.buttonGuardarCambios)
        guardarButton.setOnClickListener {
            Toast.makeText(this, "La configuración ha sido guardada", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_item_one -> {
                val intentEstadoLentes = Intent(this, EstadoLentes::class.java)
                startActivity(intentEstadoLentes)
                return true
            }

            R.id.nav_item_four -> {
                val intentNotificaciones = Intent(this, ConfigurarNotificaciones::class.java)
                startActivity(intentNotificaciones)
                return true
            }

            else -> {
                // Manejar ítems desconocidos
                Toast.makeText(this,"",Toast.LENGTH_SHORT).show()
                return false
            }
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        drawerToggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
