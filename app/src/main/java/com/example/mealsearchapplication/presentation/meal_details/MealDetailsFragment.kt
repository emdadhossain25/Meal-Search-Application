package com.example.mealsearchapplication.presentation.meal_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mealsearchapplication.databinding.FragmentMealDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

class MealDetailsFragment : Fragment() {
    private var _binding:FragmentMealDetailsBinding?=null
    val binding:FragmentMealDetailsBinding
    get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentMealDetailsBinding.inflate(inflater,container,false)
        return _binding?.root
    }

}