package com.rana.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.rana.chatapp.databinding.ActivityLoginBinding
import com.rana.chatapp.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {


    private lateinit var name :EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var signUpBtn: Button
    private lateinit var mAuth: FirebaseAuth
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        name = findViewById(R.id.nameEt)
        email = findViewById(R.id.emailEt)
        password = findViewById(R.id.passwordEt)
        signUpBtn = findViewById(R.id.signUpBtn)
        mAuth = FirebaseAuth.getInstance() //this is how we initialize firebase object

        signUpBtn.setOnClickListener{
            val email = email.text.toString()
            val password = password.text.toString()
//            val name = name.text.toString()


            signUp(email,password)
        }
    }

    private fun signUp (email : String , password :String){

    }
}