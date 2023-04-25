package com.example.myapplication.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.MAIN
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding


class homeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageButton7.setOnClickListener{
            MAIN.navController.navigate(R.id.action_homeFragment_to_fragment1)
        }
        binding.imageButton2.setOnClickListener{
            MAIN.navController.navigate(R.id.action_homeFragment_to_fragment2)
        }
        binding.imageButton3.setOnClickListener{
            MAIN.navController.navigate(R.id.action_homeFragment_to_fragment3)
        }
        binding.imageButton4.setOnClickListener{
            MAIN.navController.navigate(R.id.action_homeFragment_to_fragment4)
        }
        binding.imageButton5.setOnClickListener{
            MAIN.navController.navigate(R.id.action_homeFragment_to_fragment5)
        }
        binding.imageButton6.setOnClickListener{
            MAIN.navController.navigate(R.id.action_homeFragment_to_fragment6)
        }
    }
}