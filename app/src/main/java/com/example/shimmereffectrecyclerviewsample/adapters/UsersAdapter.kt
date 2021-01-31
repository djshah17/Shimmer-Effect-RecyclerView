package com.example.retrofitsample.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitsample.response.User
import com.example.shimmereffectrecyclerviewsample.R

class UsersAdapter(private val context: Context, private var usersList: MutableList<User>) : RecyclerView.Adapter<UsersAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.layout_user_row,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val getUser = usersList[position]
        holder.userName?.text = getUser.name
        holder.userInfo1?.text = getUser?.userName + " | " + getUser?.userEmail
        holder.userInfo2?.text = getUser?.userPhone + " | " + getUser?.userWebsite
        val userAddressObj = getUser.userAddressObject
        holder.userAddress?.text = userAddressObj?.suiteAddress + "," + userAddressObj?.streetAddress + "," + userAddressObj?.cityAddress + "," + userAddressObj?.zipCodeAddress
    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view){

        var userName: TextView? = null
        var userInfo1: TextView? = null
        var userInfo2: TextView? = null
        var userAddress: TextView? = null

        init {
            userName = view.findViewById(R.id.txt_shimmer_user_name)
            userInfo1 = view.findViewById(R.id.txt_shimmer_user_info1)
            userInfo2 = view.findViewById(R.id.txt_shimmer_user_info2)
            userAddress = view.findViewById(R.id.txt_shimmer_user_address)
        }

    }

}