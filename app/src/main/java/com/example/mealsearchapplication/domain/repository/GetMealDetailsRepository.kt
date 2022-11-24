package com.example.mealsearchapplication.domain.repository

import com.example.mealsearchapplication.data.model.MealsDTO

interface GetMealDetailsRepository {

    suspend fun getMealDeatails(id: String): MealsDTO
}