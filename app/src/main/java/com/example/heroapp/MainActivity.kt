package com.example.heroapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btComecarQuiz = findViewById<Button>(R.id.btStart)
        var etNome = findViewById<EditText>(R.id.etNome)

        btComecarQuiz.setOnClickListener {
            val comecarQuiz = Intent(this, Quiz1::class.java)
            var nome = etNome.text.toString()

            comecarQuiz.putExtra("NOME", nome)
            startActivity(comecarQuiz)
        }



    }

}