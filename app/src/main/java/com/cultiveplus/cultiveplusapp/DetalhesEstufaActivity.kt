package com.cultiveplus.cultiveplusapp

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cultiveplus.cultiveplusapp.databinding.ActivityDetalhesEstufaBinding
import com.cultiveplus.cultiveplusapp.databinding.ActivityMainBinding
import com.cultiveplus.cultiveplusapp.model.Estufa

class DetalhesEstufaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val  binding = ActivityDetalhesEstufaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val estufa: Estufa? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("estufa", Estufa::class.java)
        } else {
           intent.getSerializableExtra("estufa") as? Estufa
        }

        if (estufa != null) {
            binding.tvTituloDetalhe.text = estufa.name
        }
    }
    companion object {
        /**
         * Retorna um Intent para iniciar a UserIndexActivity.
         * Se a Activity precisasse de dados (ex: ID do usuário), eles seriam passados aqui.
         */
        fun newIntent(context: Context): Intent {
            return Intent(context, DetalhesEstufaActivity::class.java)
        }
    }
}