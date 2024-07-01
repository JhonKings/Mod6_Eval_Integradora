package com.example.wallet.data.network.api


import com.example.wallet.data.response.LoginRequest
import com.example.wallet.data.response.LoginResponse
import com.example.wallet.data.response.UserCreatedResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface WalletServiceAPI {

    @POST("users")
    suspend fun registerUser(@Body user: UserCreatedResponse): Response <UserCreatedResponse>

    @POST("auth/login")
    suspend fun userLogin(@Body login: LoginRequest): Response <LoginResponse>


}
