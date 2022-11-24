package com.example.mealsearchapplication.domain.use_case

import com.example.mealsearchapplication.common.Resource
import com.example.mealsearchapplication.data.model.toDomainMealDetails
import com.example.mealsearchapplication.domain.model.Meal
import com.example.mealsearchapplication.domain.model.MealDetails
import com.example.mealsearchapplication.domain.repository.GetMealDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMealsDetailUseCase @Inject constructor(private val mealDetailsRepository: GetMealDetailsRepository) {
    operator fun invoke(id: String): Flow<Resource<MealDetails>> = flow {
        try {
            emit(Resource.Loading())
            val response =
                mealDetailsRepository.getMealDeatails(id).meals!![0].toDomainMealDetails()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage ?: "Unknown Error"))
        }
    }
}