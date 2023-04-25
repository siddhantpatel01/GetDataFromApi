package com.example.getdatafromapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.getdatafromapi.Adapter.Post_Adapter
import com.example.getdatafromapi.Factory.Post_Factory
import com.example.getdatafromapi.Repository.Post_Repository
import com.example.getdatafromapi.ViewModel.AlbumViewModel
import com.example.getdatafromapi.ViewModel.PostViewModel
import com.example.getdatafromapi.databinding.ActivityAlbumRecyclerViewBinding
import com.example.getdatafromapi.databinding.ActivityPostBinding

class PostActivity : AppCompatActivity() {


    lateinit var binding: ActivityPostBinding

    lateinit var postAdapter: Post_Adapter
    lateinit var postViewModel: PostViewModel
    lateinit var albumViewModel: AlbumViewModel
    lateinit var postFactory: Post_Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_post)

        postFactory = Post_Factory(Post_Repository())
        postViewModel = ViewModelProvider(this,postFactory)[PostViewModel::class.java]
        binding.lifecycleOwner = this

        binding.postApi.layoutManager = LinearLayoutManager(this)

        postViewModel.getPost().observe(this, Observer {
            postAdapter = Post_Adapter(it)
            binding.postApi.adapter = postAdapter
            postAdapter.notifyDataSetChanged()
        })

    }
}