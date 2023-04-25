package com.example.getdatafromapi.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.getdatafromapi.Model.Comments_Model
import com.example.getdatafromapi.Model.Post_Model
import com.example.getdatafromapi.R
import com.example.getdatafromapi.databinding.CommentsLayoutBinding
import com.example.getdatafromapi.databinding.ItemPostBinding




class Comment_Adapter(private val Commentdata : List<Comments_Model>) : RecyclerView.Adapter<Comment_Adapter.MyViewHolder>() {

    inner class MyViewHolder(var binding : CommentsLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view : View? =  LayoutInflater.from(parent.context).inflate(R.layout.comments_layout,parent,false)
        var binding : CommentsLayoutBinding = DataBindingUtil.bind(view!!)!!
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return Commentdata.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val comment = Commentdata[position]
        holder.binding.apply {
            tvId.text = comment.id.toString()
            tvPostId.text = comment.postId.toString()
            tvName.text = comment.name
            Body.text = comment.body
            tvEmail.text = comment.email
        }
    }


}