package com.example.mealsearchapplication.domain.use_case

import com.example.mealsearchapplication.common.Resource
import com.example.mealsearchapplication.data.model.toDomainMeal
import com.example.mealsearchapplication.domain.model.Meal
import com.example.mealsearchapplication.domain.repository.MealSearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMealSearchListUseCase @Inject constructor(private val repository: MealSearchRepository) {

    // this is the interesting part
    // use case internal operator is singleton
    // invoke has any input and output param
    // returns Flow (coroutine scope)
    // returns the domain layer model object
    //
    internal operator fun invoke(s: String): Flow<Resource<List<Meal>>> = flow {
        try {

            // here we use resource will emit events for use cases
            emit(Resource.Loading())
            val response = repository.getMealList(s)

            val list =

                if (response.meals.isNullOrEmpty()) emptyList<Meal>() else response.meals.map { it.toDomainMeal() } // returns mapped

            emit(Resource.Success(data = list))


        } catch (httpException: HttpException) {
            emit(Resource.Error(httpException.localizedMessage?:"Unknown Error"))
        } catch (ioException: IOException) {
            emit(Resource.Error(ioException.localizedMessage?:"Check Your Internet Connection"))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage?:"Unknown Error"))

        }
    }
}