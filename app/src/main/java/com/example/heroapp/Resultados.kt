package com.example.heroapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Resultados : AppCompatActivity() {
    private val logica = LogicaQuiz()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)

        val placarFinal = intent.getIntArrayExtra("PLACAR_FINAL")
        val nomeResultado = findViewById<TextView>(R.id.tvResultado)

        if (placarFinal != null) {

            val heroiVencedor = logica.getResultadoFinal(placarFinal)
            nomeResultado.text = heroiVencedor.nome


        } else {
            nomeResultado.text = "Erro"
        }
    }
}