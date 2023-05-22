package com.example.firstapp.superheroapp

import com.google.gson.annotations.SerializedName

data class SuperHeroDataResponse(
    @SerializedName("response") val respuesta: String,
    @SerializedName("results") val superHeroes: List<SuperHeroItem>
)

data class SuperHeroItem(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: Image
)

data class Image(
    @SerializedName("url") val url : String
)