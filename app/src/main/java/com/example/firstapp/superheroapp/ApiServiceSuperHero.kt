package com.example.firstapp.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceSuperHero {

    @GET("10233054305565682/search/{name}")
    suspend fun getSuperHeroes(@Path("name") superHeroName: String): Response<SuperHeroDataResponse>

    @GET("10233054305565682/{id}")
    suspend fun getSuperHeroDetail(@Path("id") superHeroId: String): Response<SuperHeroDetailResponse>

}