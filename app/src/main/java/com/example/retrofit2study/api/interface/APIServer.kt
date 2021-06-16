package com.example.retrofit2study.api.`interface`


import com.example.retrofit2study.api.molds.Singup.GetSingUpRes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.retrofit2study.api.molds.SingIn.GetSingInRes as GetSingInRes1

interface APIServer {
    @GET("http://gaobook.dothome.co.kr/api/signin.php")
    fun getSingIn(@Query("username")username: String,
                  @Query("password") password: String): Call<GetSingInRes1>

    @GET("http://gaobook.dothome.co.kr/api/signup.php")
    fun getSingUp(@Query("nickname") nickname: String,
                  @Query("username") username: String,
                  @Query("password") password: String): Call<GetSingUpRes>
}