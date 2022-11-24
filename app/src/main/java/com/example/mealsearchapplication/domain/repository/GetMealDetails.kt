package com.example.mealsearchapplication.domain.repository

import com.example.mealsearchapplication.data.model.MealsDTO

interface GetMealDetails {

    suspend fun getMealDeatails(id: String): MealsDTO
}