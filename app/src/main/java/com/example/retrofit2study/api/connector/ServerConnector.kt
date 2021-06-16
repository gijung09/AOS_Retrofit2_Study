package com.example.retrofit2study.api.connector

import android.util.Log
import com.example.retrofit2study.api.ServerRetrofit
import com.example.retrofit2study.api.molds.SingIn.GetSingInRes
import com.example.retrofit2study.api.molds.Singup.GetSingUpRes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ServerConnector {

    const val TAG = "ServerConnector"

    fun getSignIn(username: String, password: String, onResponse: (GetSingInRes?) -> Unit){

        ServerRetrofit.server.getSingIn(username, password).enqueue(object : Callback<GetSingInRes> {
            override fun onResponse(call: Call<GetSingInRes>, response: Response<GetSingInRes>) {
//                val bod = response.body()!!
//                Log.d(TAG,"onResponse-getSingIn: ${response.body()?.msg}")
            }

            override fun onFailure(call: Call<GetSingInRes>, t: Throwable) {
                Log.d(TAG,"onFailure: ${t.message}")
            }
        })
    }

    fun getSignUp(nickname: String, username: String, password: String){
        ServerRetrofit.server.getSingUp(nickname, username, password).enqueue(object : Callback<GetSingUpRes>{
            override fun onResponse(call: Call<GetSingUpRes>, response: Response<GetSingUpRes>) {
                Log.d(TAG, "onResponse: ${response.body()!!.msg}")
            }

            override fun onFailure(call: Call<GetSingUpRes>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })

        }
}