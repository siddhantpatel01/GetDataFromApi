package com.example.getdatafromapi.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.getdatafromapi.Model.Post_Model
import com.example.getdatafromapi.R
import com.example.getdatafromapi.databinding.ItemPostBinding

class Post_Adapter(private val postdata : List<Post_Model>) : RecyclerView.Adapter<Post_Adapter.MyViewHolder>() {

    inner class MyViewHolder(var binding: ItemPostBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view : View? =  LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false)
        var binding : ItemPostBinding = DataBindingUtil.bind(view!!)!!
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return postdata.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val post = postdata[position]
        holder.binding.apply {
            tvId.text = post.id.toString()
            tvUserId.text = post.userId.toString()
            tvTitle.text = post.title
            Body.text = post.body
        }
    }

}