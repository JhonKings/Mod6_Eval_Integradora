package com.example.wallet.presentation.fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import com.example.wallet.R
import com.example.wallet.databinding.FragmentLoginSingupPage2Binding

class FragmentLoginSingupPage_2 : Fragment() {

    private lateinit var binding: FragmentLoginSingupPage2Binding
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
        //return inflater.inflate(R.layout.fragment_login_singup_page_2, container, false)
        //binding = FragmentLoginSingupPage2Binding.inflate(layoutInflater)
        binding = FragmentLoginSingupPage2Binding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController(view)
        val btnCrearCuenta = binding.btnCrearCuenta
        btnCrearCuenta.setOnClickListener{

            navController.navigate(R.id.fragmentSingupPage_4)

        }

        val txtYaExisteCuenta = binding.txtYaExisteCuenta
        txtYaExisteCuenta.setOnClickListener{

            navController.navigate(R.id.fragmentLoginPage_3)

        }


        //val handler = Handler()
        //handler.postDelayed({ navController.navigate(R.id.fragmentLoginPage_3) }, 3000)
    }
}