package com.example.wallet.presentation.fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import com.example.wallet.R
import com.example.wallet.databinding.FragmentLoginPage3Binding
import com.example.wallet.databinding.FragmentLoginSingupPage2Binding
import com.example.wallet.presentation.viewmodel.LoginViewModel

class FragmentLoginPage_3 : Fragment() {

    private lateinit var binding: FragmentLoginPage3Binding
    private val validater: LoginViewModel by viewModels()
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
        binding = FragmentLoginPage3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController(view)

        val btnLogin = binding.btnLogin
        btnLogin.setOnClickListener{
            var flag: Boolean = false

            /*flag = validater.usersValidate(binding.editTextEmail.text.toString(), binding.editTextPassword.text.toString())

            if(flag){
                navController.navigate(R.id.fragmentHomePage_5)
            }else{
                Toast.makeText(context, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }*/

        }

        val btnCrearCuenta = binding.txtCrearCuentaNueva
        btnCrearCuenta.setOnClickListener{

            navController.navigate(R.id.fragmentSingupPage_4)

        }

    }
}