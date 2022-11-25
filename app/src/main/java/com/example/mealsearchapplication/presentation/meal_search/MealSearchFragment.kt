package com.example.mealsearchapplication.presentation.meal_search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import com.example.mealsearchapplication.databinding.FragmentMealSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MealSearchFragment : Fragment() {
    private var _binding: FragmentMealSearchBinding? = null
    val binding: FragmentMealSearchBinding
        get() = _binding!!


    private val mealsSearchViewModel: MealSearchViewModel by viewModels()

    private val mealsSearchAdapter = MealSearchAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMealSearchBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.searchMeal.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    mealsSearchViewModel.searchMealList(it)
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }

        })


        binding.searchRecycler.apply {
            adapter = mealsSearchAdapter
        }

        lifecycle.coroutineScope.launchWhenStarted {
            mealsSearchViewModel.mealsSearchList.collect {
                if (it.isLoading) {

                }
                if (it.error.isNotBlank()) {

                }
                it.data?.let {
                    mealsSearchAdapter.setContentList(it.toMutableList())
                }

            }
        }
    }

}