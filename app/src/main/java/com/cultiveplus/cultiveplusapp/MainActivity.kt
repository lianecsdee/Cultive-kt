package com.cultiveplus.cultiveplusapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cultiveplus.cultiveplusapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(
        savedInstanceState: Bundle?,
    ) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    // MELHOR PRÁTICA: Função auxiliar para criar e iniciar o Intent.
    // Isso torna a navegação mais limpa e centralizada.
    // Isso simula o comportamento de métodos estáticos em Java
    companion object {
        /**
         * Retorna um Intent para iniciar a UserIndexActivity.
         * Se a Activity precisasse de dados (ex: ID do usuário), eles seriam passados aqui.
         */
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

}