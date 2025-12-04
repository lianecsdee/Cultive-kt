package com.cultiveplus.cultiveplusapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cultiveplus.cultiveplusapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {

        val bottomNav = binding.bottomNavigation


        bottomNav.selectedItemId = R.id.nav_home

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true

                R.id.nav_estufas -> {
                    val intent = Intent(this, NovaEstufaActivity::class.java)
                    startActivity(intent)
                    false
                }

                R.id.nav_dicas -> {
                    val intent = Intent(this, DicasActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.nav_perfil -> {
                    val intent = Intent(this, MinhaContaActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}