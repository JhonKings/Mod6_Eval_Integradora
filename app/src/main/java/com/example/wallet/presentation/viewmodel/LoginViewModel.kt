package com.example.wallet.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallet.data.local.Users
import com.example.wallet.data.model.User
import com.example.wallet.data.response.LoginRequest
import com.example.wallet.data.response.LoginResponse
import com.example.wallet.data.response.UserCreatedResponse
import com.example.wallet.domain.UseCase
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel(private val useCase: UseCase): ViewModel() {

    private var userLogin = MutableLiveData<Result<Response<LoginResponse>>>()
    val userLoginLV: LiveData <Result<Response<LoginResponse>>> = userLogin

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val response = useCase.loginUser(LoginRequest(email, password))
                if (response.isSuccessful){
                    val result= Result.success(response)
                    userLogin.postValue(result)

                }else{

                    userLogin.postValue(Result.failure(Exception("Error en el login")))
                }
            } catch (e: Exception) {
                userLogin.postValue(Result.failure(e))
            }
        }
    }

    fun almacenarEnBaseDato (email: String, password: String, token: String){
        viewModelScope.launch {
            useCase.insertUser(User(email, password, token))
        }
    }



}