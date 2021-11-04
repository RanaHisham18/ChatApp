package com.rana.chatapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.rana.chatapp.databinding.ActivityLoginBinding

class LogIn : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var logInBtn: Button
    private lateinit var signUpBtn: Button

    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.emailEt)
        password = findViewById(R.id.passwordEt)
        logInBtn = findViewById(R.id.loginBtn)
        signUpBtn = findViewById(R.id.signUpBtn)
        mAuth = FirebaseAuth.getInstance() //this is how we initialize firebase object

        signUpBtn.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)

            startActivity(intent)
        }

        logInBtn.setOnClickListener{
            val email = email.text.toString()
            val password = password.text.toString()
            logIn(email,password)
        }

    }

    private fun logIn(email : String , password :String){

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                  val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "User is not found", Toast.LENGTH_LONG).show()
                }
            }

    }
}