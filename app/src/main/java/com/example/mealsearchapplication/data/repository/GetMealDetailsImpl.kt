package com.example.mealsearchapplication.data.repository

import com.example.mealsearchapplication.data.model.MealsDTO
import com.example.mealsearchapplication.data.remote.MealSearchApi
import com.example.mealsearchapplication.domain.repository.GetMealDetails

class GetMealDetailsImpl(private val mealSearchApi: MealSearchApi) : GetMealDetails {
    override suspend fun getMealDeatails(id: String): MealsDTO {
        return mealSearchApi.getMealDetails(id)
    }
}