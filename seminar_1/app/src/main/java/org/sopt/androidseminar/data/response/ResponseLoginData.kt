package org.sopt.androidseminar.data.response

import com.google.gson.annotations.SerializedName

data class ResponseLoginData(
    val succes: Boolean,
    val message: String,
    val data: LoginData?
)
data class LoginData(
    @SerializedName("UserId")
    val userId: Int,
    val user_nickname: String,
    val token: String
)
