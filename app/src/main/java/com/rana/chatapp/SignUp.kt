package com.rana.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rana.chatapp.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }
}