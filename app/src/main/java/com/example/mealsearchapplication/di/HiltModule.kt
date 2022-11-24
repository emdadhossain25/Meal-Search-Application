package com.example.mealsearchapplication.di

import com.example.mealsearchapplication.common.Constants
import com.example.mealsearchapplication.data.remote.MealSearchApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// this module provides the dependencies to the layers

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {


    // this provides retrofit and MealsSearchAPI to ...
    @Provides
    @Singleton
    fun provideMealSearchAPI(): MealSearchApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MealSearchApi::class.java)
    }
}