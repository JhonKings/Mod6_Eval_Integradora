package com.example.wallet.presentation.fragments

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import com.example.wallet.R
import com.example.wallet.data.local.database.AppDatabase
import com.example.wallet.data.network.api.WalletServiceAPI
import com.example.wallet.data.network.retrofit.RetrofitHelper
import com.example.wallet.data.repository.RepositoryImp
import com.example.wallet.data.response.UserCreatedResponse
import com.example.wallet.databinding.FragmentLoginPage3Binding
import com.example.wallet.databinding.FragmentSingupPage4Binding
import com.example.wallet.domain.UseCase
import com.example.wallet.presentation.viewmodel.SignUpViewModel
import com.example.wallet.presentation.viewmodel.ViewModelFactory

class FragmentSingupPage_4 : Fragment() {

    private lateinit var binding: FragmentSingupPage4Binding
    private lateinit var viewModel: SignUpViewModel

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
        binding = FragmentSingupPage4Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController(view)
        val apiservice = RetrofitHelper.getRetrofit().create(WalletServiceAPI::class.java)
        val application = requireActivity().application
        val baseDatos = AppDatabase.getDatabase(application)
        val repository = RepositoryImp (apiservice, baseDatos.userDAO())
        val useCase = UseCase(repository)
        val viewModelFactory = ViewModelFactory(useCase)
        viewModel = ViewModelProvider(this, viewModelFactory)[SignUpViewModel::class.java]


        val btnLogin = binding.btnCrearCuenta
        btnLogin.setOnClickListener{

            val name = binding.editTextTextNombre.text.toString()
            val apellido = binding.editTextTextApellido.text.toString()
            val email = binding.editTextTextEmail.text.toString()
            val password = binding.editTextTextPassword.text.toString()
            val rePassword = binding.editTextTextReingresarContrasena.text.toString()


            val userResponse = UserCreatedResponse(0, name, apellido, email, password, null, 1, null, null)
            Log.i("userResponse", userResponse.toString())
            viewModel.createUser(userResponse)



            viewModel.livedata.observe(viewLifecycleOwner) {result ->

                result.onSuccess {
                    Toast.makeText(requireContext(), "Usuario creado correctamente", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.fragmentLoginPage_3)
                }
                result.onFailure {
                    Toast.makeText(requireContext(), "Error al crear usuario", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}