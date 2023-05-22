package com.example.firstapp.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.databinding.ItemSuperheroBinding

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(hero: SuperHeroItem){
        binding.tvSuperHeroName.text = hero.name
        binding.ivSuperHero

    }
}