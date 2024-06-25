package com.example.wallet.presentation.fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.example.wallet.R
import com.example.wallet.databinding.FragmentLoginPage3Binding
import com.example.wallet.databinding.FragmentRequestMoney7Binding

class FragmentRequestMoney_7 : Fragment() {

    private lateinit var binding: FragmentRequestMoney7Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRequestMoney7Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController(view)

        val btnVolver = binding.imgArrowBack
        btnVolver.setOnClickListener{

            navController.navigate(R.id.fragmentHomePage_5)

        }

    }
}