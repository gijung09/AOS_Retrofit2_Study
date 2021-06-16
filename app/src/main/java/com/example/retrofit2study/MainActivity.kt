package com.example.retrofit2study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofit2study.api.connector.ServerConnector

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val nickname = "조준형"
        val username = "test"
        val password = "pwd123"
        ServerConnector.getSignUp(nickname, username, password)
        //ServerConnector.getSignIn("pcm123", "password123")
    }
}