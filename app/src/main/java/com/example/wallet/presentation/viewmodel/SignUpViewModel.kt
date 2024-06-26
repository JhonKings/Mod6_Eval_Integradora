package com.example.wallet.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallet.data.response.UserCreatedResponse
import com.example.wallet.domain.UseCase
import kotlinx.coroutines.launch
import retrofit2.Response

class SignUpViewModel(
    private val useCase: UseCase): ViewModel() {

    private val newUser = MutableLiveData<Result<Response<UserCreatedResponse>>>()
    val livedata : LiveData<Result<Response<UserCreatedResponse>>> = newUser

    fun createUser(user: UserCreatedResponse){
        viewModelScope.launch {


            try {
                var response = useCase.createUser(user)
                if (response.isSuccessful) {
                    newUser.postValue(Result.success(response))
                } else {
                    newUser.postValue(Result.failure(Exception("Error al registrar usuario")))
                }
            } catch (e: Exception) {
                newUser.postValue(Result.failure(e))
            }

        }
    }
}