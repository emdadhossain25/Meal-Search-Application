package com.example.mealsearchapplication.data.repository

import com.example.mealsearchapplication.data.model.MealsDTO
import com.example.mealsearchapplication.data.remote.MealSearchApi
import com.example.mealsearchapplication.domain.repository.GetMealDetailsRepository

class GetMealDetailsImpl(private val mealSearchApi: MealSearchApi) : GetMealDetailsRepository {
    override suspend fun getMealDeatails(id: String): MealsDTO {
        return mealSearchApi.getMealDetails(id)
    }
}