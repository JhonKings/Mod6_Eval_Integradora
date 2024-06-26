package com.example.wallet.data.response

import com.google.gson.annotations.SerializedName

data class UserCreatedResponse(

    val id: Long,
    @SerializedName("first_name")
    val firstname: String,
    @SerializedName("last_name")
    val lastname: String,
    val email: String,
    val password: String,
    val points: Long?,
    val roleId: Long,
    val createdAt: String?,
    val updatedAt: String?
)
