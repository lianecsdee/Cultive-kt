package com.cultiveplus.cultiveplusapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class DicasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dicas)

        // Navegation bar feita por Hugo
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.nav_dicas

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_estufas -> {
                    startActivity(Intent(this, NovaEstufaActivity::class.java))
                    true
                }
                R.id.nav_dicas -> true
                R.id.nav_perfil -> {
                    startActivity(Intent(this, MinhaContaActivity::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }
    }
}