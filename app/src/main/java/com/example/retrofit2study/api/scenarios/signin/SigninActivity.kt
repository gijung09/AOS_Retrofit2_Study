package com.example.retrofit2study.api.scenarios.signin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.retrofit2study.R
import com.example.retrofit2study.api.connector.ServerConnector

class SigninActivity : AppCompatActivity() {
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnSignIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        initUI()
        initListener()
    }
    private fun initUI(){
        edtUsername = findViewById(R.id.edt_username)
        edtPassword = findViewById(R.id.edt_password)
        btnSignIn = findViewById(R.id.bt_signin_login)
    }

    private fun initListener(){
        val username = edtUsername.text.toString()
        val password = edtPassword.text.toString()

        ServerConnector.getSignIn(username, password) {
            when {
                it == null -> showToast("서버 오류가 발생하였습니다")
                it?.code != 0 -> showToast(it?.msg)
                else -> showToast("로그인 성공")
            }

        }
    }
    private fun showToast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}