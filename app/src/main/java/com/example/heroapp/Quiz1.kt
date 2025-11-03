package com.example.heroapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import kotlin.math.log

class Quiz1 : AppCompatActivity() {

    private val logica = LogicaQuiz()

    private lateinit var tvPergunta: TextView
    private lateinit var btOpcao1: Button
    private lateinit var btOpcao2: Button
    private lateinit var btOpcao3: Button
    private lateinit var btOpcao4: Button
    private lateinit var placar: IntArray
    private lateinit var pergunta: Pergunta
    private var selecaoAtual: List<Int>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz1)

        tvPergunta = findViewById<TextView>(R.id.tvTitle)
        btOpcao1 = findViewById<Button>(R.id.btOpcao1)
        btOpcao2 = findViewById<Button>(R.id.btOpcao2)
        btOpcao3 = findViewById<Button>(R.id.btOpcao3)
        btOpcao4 = findViewById<Button>(R.id.btOpcao4)

        placar = logica.criarPlacarInicial()

        val btAvancar = findViewById<Button>(R.id.btAvancar)
        val nomeRecebido = intent.getStringExtra("NOME") ?: ""
        pergunta = logica.getPergunta(0)

        tvPergunta.text = pergunta.textoDaPergunta
        btOpcao1.text = pergunta.opcoes[0].texto
        btOpcao2.text = pergunta.opcoes[1].texto
        btOpcao3.text = pergunta.opcoes[2].texto
        btOpcao4.text = pergunta.opcoes[3].texto
        btOpcao1.setCompoundDrawablesWithIntrinsicBounds(
            0, // left
            pergunta.opcoes[0].imagem, // top
            0, // right
            0  // bottom
        )
        btOpcao2.setCompoundDrawablesWithIntrinsicBounds(
            0, // left
            pergunta.opcoes[1].imagem, // top
            0, // right
            0  // bottom
        )
        btOpcao3.setCompoundDrawablesWithIntrinsicBounds(
            0, // left
            pergunta.opcoes[2].imagem, // top
            0, // right
            0  // bottom
        )
        btOpcao4.setCompoundDrawablesWithIntrinsicBounds(
            0, // left
            pergunta.opcoes[3].imagem, // top
            0, // right
            0  // bottom
        )

        btOpcao1.setOnClickListener {
            selecaoAtual = pergunta.opcoes[0].heroiIds
            btOpcao1.alpha = 1.0f // Selecionado
            btOpcao2.alpha = 0.5f // Não selecionado
            btOpcao3.alpha = 0.5f
            btOpcao4.alpha = 0.5f
        }
        btOpcao2.setOnClickListener {
            selecaoAtual = pergunta.opcoes[1].heroiIds
            btOpcao1.alpha = 0.5f
            btOpcao2.alpha = 1.0f
            btOpcao3.alpha = 0.5f
            btOpcao4.alpha = 0.5f
        }
        btOpcao3.setOnClickListener {
            selecaoAtual = pergunta.opcoes[2].heroiIds
            btOpcao1.alpha = 0.5f
            btOpcao2.alpha = 0.5f
            btOpcao3.alpha = 1.0f
            btOpcao4.alpha = 0.5f
        }
        btOpcao4.setOnClickListener {
            selecaoAtual = pergunta.opcoes[3].heroiIds
            btOpcao1.alpha = 0.5f
            btOpcao2.alpha = 0.5f
            btOpcao3.alpha = 0.5f
            btOpcao4.alpha = 1.0f
        }

        btAvancar.setOnClickListener {
            if (selecaoAtual == null) {
                Toast.makeText(this, "Por favor, escolha uma opção", Toast.LENGTH_SHORT).show()
            } else {
                registrarRespostaLocal(selecaoAtual!!)
                val proximaPagina = Intent(this, Quiz2::class.java)
                proximaPagina.putExtra("PLACAR_ATUAL", placar)
                proximaPagina.putExtra("NOME", nomeRecebido)
                startActivity(proximaPagina)
            }
        }
    }


    private fun registrarRespostaLocal(heroiIndices: List<Int>) {
        for (id in heroiIndices) {
            // Converte o ID (1-8) para o índice (0-7)
            val index = id - 1

            // Adiciona uma verificação de segurança
            if (index >= 0 && index < placar.size) {
                placar[index]++
            }
        }
    }
}