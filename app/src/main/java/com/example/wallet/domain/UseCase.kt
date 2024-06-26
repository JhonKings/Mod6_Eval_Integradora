package com.example.wallet.domain

import com.example.wallet.data.repository.UserRepository
import com.example.wallet.data.response.UserCreatedResponse
import retrofit2.Response


class UseCase(private val userRepository: UserRepository) {

    suspend fun createUser (user: UserCreatedResponse): Response<UserCreatedResponse> {
        return userRepository.crearUser(user)
    }


    /*suspend fun logingUser (user: LoginRequest): Response<LoginResponse> {
        return userRepository.loginUser(user)
    }

    suspend fun insertUser (user: User){
        return userRepository.insertarUsuarioBaseDatos(user)
    }*/

}