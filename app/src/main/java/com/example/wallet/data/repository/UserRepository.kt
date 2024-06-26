package com.example.wallet.data.repository

import com.example.wallet.data.response.UserCreatedResponse
import retrofit2.Response

interface UserRepository {

    suspend fun crearUser(user: UserCreatedResponse): Response<UserCreatedResponse>

    /*suspend fun loginUser(user: LoginRequest): Response<LoginResponse>

    suspend fun insertarUsuarioBaseDatos(user: User)*/

}
