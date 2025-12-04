package com.cultiveplus.cultiveplusapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MinhaContaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minha_conta)


        //navegation bar feita por hugo
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.nav_perfil

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
                R.id.nav_dicas -> {
                    startActivity(Intent(this, DicasActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_perfil -> true
                else -> false
            }
        }
    }
}