package com.example.firstapp.superheroapp

import com.google.gson.annotations.SerializedName

data class SuperHeroDataResponse(
    @SerializedName("response") val respuesta: String,
    @SerializedName("results") val superHero: List<SuperHeroItem>
)

data class SuperHeroItem(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String
)