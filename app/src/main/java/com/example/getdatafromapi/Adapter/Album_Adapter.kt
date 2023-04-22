package com.example.getdatafromapi.Adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.getdatafromapi.R
import com.example.getdatafromapi.Response.Album
import com.example.getdatafromapi.Response.AlbumData
import com.example.getdatafromapi.databinding.ItemAlbumBinding

class Album_Adapter(private val albumData: List<Album>) : RecyclerView.Adapter<Album_Adapter.MyViewHolder>() {

    inner class MyViewHolder(var binding: ItemAlbumBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view: View? = LayoutInflater.from(parent.context).inflate(R.layout.item_album, parent, false)
        var binding: ItemAlbumBinding = DataBindingUtil.bind(view!!)!!
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return albumData.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val album = albumData[position]

        holder.binding.apply {
            tvId.text = album.id.toString()
            tvUserId.text = album.userId.toString()
            tvTitle.text = album.title
        }
    }
}