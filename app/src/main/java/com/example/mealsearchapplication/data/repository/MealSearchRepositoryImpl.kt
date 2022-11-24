package com.example.mealsearchapplication.data.repository

import com.example.mealsearchapplication.data.model.MealsDTO
import com.example.mealsearchapplication.data.remote.MealSearchApi
import com.example.mealsearchapplication.domain.repository.MealSearchRepository

class MealSearchRepositoryImpl(private val mealSearchApi: MealSearchApi):MealSearchRepository {
    override suspend fun getMealList(s: String): MealsDTO {
        return mealSearchApi.getMealsList(s)
    }
}