package com.cultiveplus.cultiveplusapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NovaEstufaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova_estufa)

        // 1. Configurar Botão Voltar
        val btnVoltar = findViewById<ImageButton>(R.id.btnVoltar)
        btnVoltar.setOnClickListener {
            finish()
        }

        // 2. Configurar o Spinner (Lista de Plantas)
        val spinnerPlanta = findViewById<Spinner>(R.id.spinnerPlanta)

        // Lista de opções fake para aparecer na tela
        val plantas = listOf("Selecione a espécie", "Coentro", "Alface", "Tomate", "Manjericão", "Pimenta")

        // Criando o adaptador que joga os textos na lista
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, plantas)
        spinnerPlanta.adapter = adapter

        // 3. Configurar Botão Criar (Simulação)
        val btnCriar = findViewById<Button>(R.id.btnCriarEstufa)
        btnCriar.setOnClickListener {
            // Aqui futuramente salvaremos no banco de dados
            Toast.makeText(this, "Estufa criada com sucesso!", Toast.LENGTH_SHORT).show()
            finish() // Fecha a tela e volta para a lista
        }
    }

    // Atalho para abrir esta tela
    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, NovaEstufaActivity::class.java)
        }
    }
}