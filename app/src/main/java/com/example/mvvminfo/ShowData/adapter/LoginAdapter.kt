package com.example.mvvminfo.ShowData.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvminfo.ShowData.model.ShowResponse
import com.example.mvvminfo.databinding.ItemLayoutBinding

class LoginAdapter(private val context: Context, private val dataList: ShowResponse?) : RecyclerView.Adapter<LoginAdapter.ViewHolder>() {
    inner class ViewHolder(private  var binding: ItemLayoutBinding) :  RecyclerView.ViewHolder(binding.root){
        fun bind(list: ShowResponse?, position: Int) {
            binding.tvName.text=list?.get(position)?.Paymentmode
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList,position)
    }
}