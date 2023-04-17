package com.example.firstapp.nameApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.firstapp.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        // RECUPERO LOS DATOS DEL intent
        val name: String? = intent.extras?.getString("EXTRA_NAME")

        if(name != null){
            tvResult.text = "Hola $name"
        }
    }
}