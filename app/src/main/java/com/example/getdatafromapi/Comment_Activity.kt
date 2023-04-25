package com.example.getdatafromapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.getdatafromapi.Adapter.Comment_Adapter
import com.example.getdatafromapi.Adapter.Post_Adapter
import com.example.getdatafromapi.Factory.Comments_Factory
import com.example.getdatafromapi.Factory.Post_Factory
import com.example.getdatafromapi.Repository.Comments_Repository
import com.example.getdatafromapi.Repository.Post_Repository
import com.example.getdatafromapi.ViewModel.AlbumViewModel
import com.example.getdatafromapi.ViewModel.Comment_ViewModel
import com.example.getdatafromapi.ViewModel.PostViewModel
import com.example.getdatafromapi.databinding.ActivityCommentBinding
import com.example.getdatafromapi.databinding.ActivityPostBinding

class Comment_Activity : AppCompatActivity() {

    lateinit var binding: ActivityCommentBinding

    lateinit var commentAdapter: Comment_Adapter
    lateinit var commentViewmodel: Comment_ViewModel
    lateinit var commentsFactory: Comments_Factory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_comment)

        commentsFactory = Comments_Factory(Comments_Repository())
        commentViewmodel = ViewModelProvider(this,commentsFactory)[Comment_ViewModel::class.java]
        binding.lifecycleOwner = this

        binding.commentRecyclerview.layoutManager = LinearLayoutManager(this)

        commentViewmodel.getComments().observe(this, Observer {
            commentAdapter = Comment_Adapter(it)
            binding.commentRecyclerview.adapter = commentAdapter
            commentAdapter.notifyDataSetChanged()
        })
    }
}