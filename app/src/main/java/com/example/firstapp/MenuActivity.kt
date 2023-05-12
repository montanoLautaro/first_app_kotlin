package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstapp.imccalculator.ImcCalculatorActivity
import com.example.firstapp.nameApp.FirstAppActivity
import com.example.firstapp.databinding.ActivityMenuBinding
import com.example.firstapp.superheroapp.SuperHeroListActivity
import com.example.firstapp.todoapp.TodoActivity


class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSaludoApp.setOnClickListener {
            navigateToSaludoApp()
        }

        binding.btnImcApp.setOnClickListener{
            navigateToImcApp()
        }

        binding.btnTODO.setOnClickListener {
            navigateToTODO()
        }

        binding.btnSuperHero.setOnClickListener{
            navigateToSuperHeroApp()
        }


    }

    private fun navigateToSuperHeroApp() {
        val intent = Intent(this, SuperHeroListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToTODO() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
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