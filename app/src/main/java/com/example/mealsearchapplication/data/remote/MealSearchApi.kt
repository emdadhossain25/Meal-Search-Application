package com.example.mealsearchapplication.data.remote

import com.example.mealsearchapplication.data.model.MealsDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface MealSearchApi {

    @GET("api/json/v1/1/search.php")
    suspend fun getMealsList(@Query("s") s: String): MealsDTO


    @GET("api/json/v1/1/lookup.php")
    suspend fun getMealDetails(@Query("i") i: String): MealsDTO
}