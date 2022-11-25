package com.example.mealsearchapplication.presentation.meal_search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealsearchapplication.common.Resource
import com.example.mealsearchapplication.domain.use_case.GetMealSearchListUseCase
import com.example.mealsearchapplication.domain.use_case.GetMealsDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class MealSearchViewModel @Inject constructor(
    private val getMealSearchListUseCase: GetMealSearchListUseCase
) : ViewModel() {


    private val _mealSearchList = MutableStateFlow<MealSearchState>(MealSearchState())
    val mealsSearchList: StateFlow<MealSearchState> = _mealSearchList


    fun searchMealList(s: String) {
        getMealSearchListUseCase(s).onEach {
            when (it) {
                is Resource.Loading -> {
                    _mealSearchList.value = MealSearchState(isLoading = true)
                }
                is Resource.Success -> {
                    _mealSearchList.value = MealSearchState(isLoading = false, data = it.data)
                }
                is Resource.Error -> {
                    _mealSearchList.value = MealSearchState(error = it.message ?: "Unknown Error")
                }
            }
        }.launchIn(viewModelScope)
    }
}