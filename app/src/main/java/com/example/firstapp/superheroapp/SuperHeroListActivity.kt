package com.example.firstapp.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import com.example.firstapp.databinding.ActivitySuperHeroListBinding

class SuperHeroListActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySuperHeroListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()

    }

    private fun initUi() {
        binding.svSuperHero.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty() )

                // siempre se retorna un false
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                TODO("Not yet implemented")
            }

        })
    }

    private fun searchByName(query: String) {
        TODO("Not yet implemented")
    }
}