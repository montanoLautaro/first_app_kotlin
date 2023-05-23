package com.example.firstapp.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(hero: SuperHeroItem, onItemSelected: (String) -> Unit){
        binding.tvSuperHeroName.text = hero.name
        if(hero.image.url != null){
            Picasso.get()
                .load(hero.image.url)
                .into( binding.ivSuperHero)
        }
        binding.root.setOnClickListener{
            onItemSelected(hero.id)
        }

    }
}