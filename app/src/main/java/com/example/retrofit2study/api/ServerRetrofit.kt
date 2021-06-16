package com.example.retrofit2study.api

import com.example.retrofit2study.api.`interface`.APIServer
import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory

object ServerRetrofit {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://gaobook.dothome.co.kr")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val server: APIServer get() = retrofit.create(APIServer::class.java)
}