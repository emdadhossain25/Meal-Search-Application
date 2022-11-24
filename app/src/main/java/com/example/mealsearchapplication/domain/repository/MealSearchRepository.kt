package com.example.mealsearchapplication.domain.repository

import com.example.mealsearchapplication.data.model.MealsDTO

interface MealSearchRepository {

    // here this is not implemented in domain hence using MealsDTO not Meals
    // using data layer model instead of domain model
    suspend fun getMealList(s: String): MealsDTO

}