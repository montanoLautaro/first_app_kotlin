package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.firstapp.imccalculator.ImcCalculatorActivity
import com.example.firstapp.nameApp.FirstAppActivity


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnSaludoApp = findViewById<AppCompatButton>(R.id.btnSaludoApp)
        val btnImcApp = findViewById<AppCompatButton>(R.id.btnImcApp)

        btnSaludoApp.setOnClickListener {
            navigateToSaludoApp()
        }

        btnImcApp.setOnClickListener{
            navigateToImcApp()
        }
    }

    private fun navigateToImcApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludoApp() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

}