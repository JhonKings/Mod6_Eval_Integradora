package com.example.wallet.data.network.api


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

    /*@POST("auth/login")
    suspend fun userLogin(@Body login: LoginRequest): Response <LoginResponse>*/


   /* @POST("accounts")
    fun createAccount(@Header("Authorization") token: String, @Body transaction: Transaction): Call<Transaction>

    @GET("transactions/{userId}")
    fun getTransactions(
        @Header("Authorization") token: String,
        @Path("userId") userId: Int
    ): Call<List<Transaction>>

    @GET("user/{userId}")
    fun getUserDetails(
        @Header("Authorization") token: String,
        @Path("userId") userId: Int
    ): Call<User>*/
}
