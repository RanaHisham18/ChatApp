package com.rana.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.rana.chatapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private lateinit var userRecyclerView: RecyclerView
private lateinit var userList :ArrayList<UserData>
private lateinit var adapter : UserLayoutAdapter
private lateinit var mAuth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
 mAuth = FirebaseAuth.getInstance()
        userList  = ArrayList()
        adapter = UserLayoutAdapter(this, userList)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.logOut){
            //the user will log out
                mAuth.signOut()
            finish()
                return true
    }
    return true
} }