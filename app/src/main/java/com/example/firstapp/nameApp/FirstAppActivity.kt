package com.example.firstapp.nameApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.firstapp.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
        val btnPulsar = findViewById<AppCompatButton>(R.id.btnPulsar)
        val etName = findViewById<AppCompatEditText>(R.id.etName)


        btnPulsar.setOnClickListener{
            val name = etName.text.toString()

            if (name.isNotEmpty()){
                Log.i("prueba", "Botón pulsado: $name")
                val intent = Intent(this, ResultActivity::class.java)

                // guardo datos en el intent, para que los pueda recuperar otra pantalla
                intent.putExtra("EXTRA_NAME", name)
                startActivity(intent)
            }
        }

    }
}