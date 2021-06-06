package org.sopt.androidseminar.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private const val BASE_URL = "http://cherishserver.com" //domain name

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()) //retrofit에서 json을 dataClass로 바꿔줄 gson 연결
        .build()
    val soptService: SoptService = retrofit.create(SoptService::class.java)
}