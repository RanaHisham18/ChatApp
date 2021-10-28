package com.rana.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.rana.chatapp.databinding.ActivityLoginBinding

class LogIn : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var email: EditText
    private lateinit var password : EditText
    private lateinit var logIn: Button
    private lateinit var signUp : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        email = binding.emailEt
//        password = binding.passwordEt
//        logIn = binding.loginBtn
//        signUp = binding.signUpBtn

        email=findViewById(R.id.emailEt)
        signUp = findViewById(R.id.signUpBtn)
        logIn = findViewById(R.id.loginBtn)
        signUp = findViewById(R.id.signUpBtn)


       signUp.setOnClickListener{
             val intent = Intent(this, signUp :: class.java)

           startActivity(intent)

       }

    }
}