package com.rana.chatapp

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.ActionCodeSettings
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


            signUp(email,password)
        }
    }

    private fun signUp (email : String , password :String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, go to main activity

                    val intent = Intent(this , MainActivity::class.java)
                    startActivity(intent)

                } else {
                    // If sign in fails, display a message to the user.
                     Toast.makeText(this, "Error occurred during sign up!", Toast.LENGTH_LONG).show()
                }
            }
    }
}