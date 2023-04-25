package com.example.getdatafromapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.getdatafromapi.Repository.Album_Repository
import com.example.getdatafromapi.ViewModel.AlbumViewModel
import com.example.getdatafromapi.databinding.ActivityAlbumRecyclerViewBinding
import com.example.getdatafromapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.albums.setOnClickListener(this)
        binding.posts.setOnClickListener(this)
        binding.Comments.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.albums ->{
                startActivity(Intent(this,Album_RecyclerView::class.java))
            }
            R.id.posts ->{
                startActivity(Intent(this,PostActivity::class.java))
            }
            R.id.Comments ->{
                startActivity(Intent(this,Comment_Activity::class.java))
            }

        }
    }
}