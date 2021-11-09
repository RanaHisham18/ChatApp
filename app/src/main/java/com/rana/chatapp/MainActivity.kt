package com.rana.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.rana.chatapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private lateinit var userRecyclerView: RecyclerView
private lateinit var userList :ArrayList<UserData>
private lateinit var adapter : UserLayoutAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userList  = ArrayList()
        adapter = UserLayoutAdapter(this, userList)
    }
}