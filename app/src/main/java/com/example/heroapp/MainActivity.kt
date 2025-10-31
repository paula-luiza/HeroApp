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

        val btStart = findViewById<Button>(R.id.btStart)
        val etNome = findViewById<EditText>(R.id.etNome)
        var nome:String

        btStart.setOnClickListener {
            nome = etNome.text.toString()

            val intent = Intent(this, Quiz1::class.java)
            intent.putExtra("NOME", nome)
            startActivity(intent)
        }
    }
}