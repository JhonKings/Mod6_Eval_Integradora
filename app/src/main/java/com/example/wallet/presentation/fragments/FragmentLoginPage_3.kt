package com.example.wallet.presentation.fragments

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import com.example.wallet.R
import com.example.wallet.data.local.database.AppDatabase
import com.example.wallet.data.network.api.WalletServiceAPI
import com.example.wallet.data.network.retrofit.RetrofitHelper
import com.example.wallet.data.repository.RepositoryImp
import com.example.wallet.databinding.FragmentLoginPage3Binding
import com.example.wallet.databinding.FragmentLoginSingupPage2Binding
import com.example.wallet.domain.UseCase
import com.example.wallet.presentation.viewmodel.LoginViewModel
import com.example.wallet.presentation.viewmodel.SignUpViewModel
import com.example.wallet.presentation.viewmodel.ViewModelFactory

class FragmentLoginPage_3 : Fragment() {

    private lateinit var binding: FragmentLoginPage3Binding
    private lateinit var viewModel: LoginViewModel

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

        val apiservice = RetrofitHelper.getRetrofit().create(WalletServiceAPI::class.java)
        val application = requireActivity().application
        val baseDatos = AppDatabase.getDatabase(application)
        val repository = RepositoryImp (apiservice, baseDatos.userDAO())
        val useCase = UseCase(repository)
        val viewModelFactory = ViewModelFactory(useCase)
        viewModel = ViewModelProvider(this, viewModelFactory)[LoginViewModel::class.java]


        btnLogin.setOnClickListener{
            val varEmail = binding.editTextEmail.text.toString()
            val varPassword = binding.editTextPassword.text.toString()

            viewModel.login(varEmail, varPassword)

            viewModel.userLoginLV.observe(viewLifecycleOwner){result ->
                result.onSuccess {response ->
                    val token = response.body()?.accessToken.toString()
                    viewModel.almacenarEnBaseDato(varEmail,varPassword, token)

                    navController.navigate(R.id.fragmentHomePage_5)
                }
            }

        }

        val btnCrearCuenta = binding.txtCrearCuentaNueva
        btnCrearCuenta.setOnClickListener{

            navController.navigate(R.id.fragmentSingupPage_4)

        }

    }
}