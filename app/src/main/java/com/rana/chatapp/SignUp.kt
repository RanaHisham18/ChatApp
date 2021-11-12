package com.rana.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
//import com.rana.chatapp.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {


    private lateinit var name :EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var signUpBtn: Button
    private lateinit var mAuth: FirebaseAuth
    //variable fot the authentication of firebase
    private lateinit var mDbRef: DatabaseReference
    //variable to hold the database id
//    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

         supportActionBar?.hide()
        name = findViewById(R.id.nameEt)
        email = findViewById(R.id.emailEt)
        password = findViewById(R.id.passwordEt)
        signUpBtn = findViewById(R.id.signUpBtn)
        mAuth = FirebaseAuth.getInstance() //this is how we initialize firebase object


        signUpBtn.setOnClickListener{
            val name = name.text.toString()
            val email = email.text.toString()
            val password = password.text.toString()


            signUp(name,email,password)
        }
    }

    private fun signUp (name: String, email : String , password :String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    addUserToDb(name, email, mAuth.currentUser?.uid!!)
                    //  method to add the user to the database (real time database)
                    Toast.makeText(this, "User Created Seccessfully!", Toast.LENGTH_LONG).show()
                    val intent = Intent(this , MainActivity::class.java)
                    finish()
                    startActivity(intent)
                    // Sign in success, go to main activity
                }
                else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "Error occurred during sign up!", Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun addUserToDb(name: String , email: String, uid : String){
        //method to add the user to the database
        mDbRef = FirebaseDatabase.getInstance().getReference()
        mDbRef.child("user").child(uid).setValue(UserData(name , email, uid))
        //create a unique Id for every user

    }
}