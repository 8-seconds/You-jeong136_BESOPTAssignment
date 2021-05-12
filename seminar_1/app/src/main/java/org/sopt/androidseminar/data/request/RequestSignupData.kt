package org.sopt.androidseminar.data.request

import com.google.gson.annotations.SerializedName

data class RequestSignupData(

    @SerializedName("email")
    val id: String,
    val birth: String,
    val nickname: String,
    val password: String,
    val phone: String,
    val sex: String
)