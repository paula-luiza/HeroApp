package com.example.heroapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Resultados : AppCompatActivity() {
    private val logica = LogicaQuiz()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)

        val placarFinal = intent.getIntArrayExtra("PLACAR_FINAL")
        val nomeResultado = findViewById<TextView>(R.id.tvResultado)
        var imagemResultado = findViewById<ImageView>(R.id.ivImagem)
        val btShare = findViewById<FloatingActionButton>(R.id.btShare)
        val btHome = findViewById<Button>(R.id.btInicio)
        val nome = intent.getStringExtra("NOME")

        if (placarFinal == null) {
            nomeResultado.text = "Erro"

        } else {

            val heroiVencedor = logica.getResultadoFinal(placarFinal)
            nomeResultado.text = nome + ", seu héroi é:" + heroiVencedor.nome
            imagemResultado.setImageResource(heroiVencedor.imagemHeroi)

            btShare.setOnClickListener {
                val compartilhar = Intent(Intent.ACTION_VIEW)
                compartilhar.data = Uri.parse("https://www.google.com/search?q=" + heroiVencedor.nome)
                startActivity(compartilhar)
            }

            btHome.setOnClickListener{
                val home = Intent(this, MainActivity::class.java)
                startActivity(home)
            }
        }


    }
}