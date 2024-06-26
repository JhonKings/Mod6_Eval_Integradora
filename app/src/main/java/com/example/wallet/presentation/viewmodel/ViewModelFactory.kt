package com.example.wallet.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wallet.domain.UseCase

class ViewModelFactory (private val useCase: UseCase)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {


        return when {
            modelClass.isAssignableFrom(SignUpViewModel::class.java) -> {
                SignUpViewModel(useCase) as T
            }

            /*modelClass.isAssignableFrom(LoginPageViewModel::class.java) -> {
                LoginPageViewModel(useCase) as T
            }*/
            else -> {
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }
}