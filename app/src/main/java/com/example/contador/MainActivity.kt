package com.example.contador

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var contador= 0
        val etContador= findViewById<TextView>(R.id.contador)
        etContador.apply {
            text= contador.toString()
        }

        val btSuma= findViewById<Button>(R.id.suma)
        btSuma.setOnClickListener {
            contador= etContador.text.toString().toInt()
            contador++
            etContador.text= contador.toString()
        }

        val btResta= findViewById<Button>(R.id.resta)
        btResta.setOnClickListener {
            contador= etContador.text.toString().toInt()
            if (contador > 0){
                contador--
                etContador.text = contador.toString()
            }
        }


        val btReset= findViewById<Button>(R.id.reset)
        btReset.setOnClickListener {
            etContador.text= "0"
        }
    }
}