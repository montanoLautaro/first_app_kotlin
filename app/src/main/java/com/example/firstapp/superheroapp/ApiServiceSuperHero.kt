package com.example.firstapp.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceSuperHero {

    @GET("10233054305565682/search/{name}")
    suspend fun getSuperHeroes(@Path("name") suerHeroName: String): Response<SuperHeroDataResponse>

}