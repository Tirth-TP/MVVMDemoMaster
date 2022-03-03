package com.example.mvvmdemomaster.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemomaster.retroFit.UserItem
import com.example.mvvmdemomaster.databinding.RvApiCallingBinding

/**
 * Created by Tirth Patel.
 */
class UserAdapter(val userItem: ArrayList<UserItem>, param: Any) : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    class MyViewHolder(var binding: RvApiCallingBinding) :RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(RvApiCallingBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.retroFit = userItem[position]
    }

    override fun getItemCount(): Int {
        return userItem.size
    }
}