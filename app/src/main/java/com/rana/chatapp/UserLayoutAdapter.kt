package com.rana.chatapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserLayoutAdapter(val context: Context, val userList: ArrayList<UserData>) : RecyclerView.Adapter<UserLayoutAdapter.ViewHolder>() {



    class ViewHolder(itemView : View) : RecyclerView.ViewHolder (itemView){
        val textName = itemView.findViewById<TextView>(R.id.nameItemTv)

        //inflating the name of the user to be displayed in the textview in the list

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     val view : View = LayoutInflater.from(context).inflate(R.layout.users_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     val currentUser = userList[position]

        holder.textName.text = currentUser.name
    }

    override fun getItemCount(): Int {
      return userList.size
    }

}