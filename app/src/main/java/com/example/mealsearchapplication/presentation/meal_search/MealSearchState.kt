package com.example.mealsearchapplication.presentation.meal_search

import com.example.mealsearchapplication.domain.model.Meal

data class MealSearchState(
    val data:List<Meal>? = null,
    val error:String="",
    val isLoading:Boolean=false
)
