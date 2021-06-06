package org.sopt.androidseminar.data.response

import com.google.gson.annotations.SerializedName

data class ResponseSignupData(
    val succes: Boolean,
    val message: String,
    val data: SignupData?
)
data class SignupData(
        val nickname: String,
)
