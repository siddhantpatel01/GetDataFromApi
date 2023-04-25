package com.example.getdatafromapi.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.getdatafromapi.Repository.Post_Repository
import com.example.getdatafromapi.ViewModel.PostViewModel

class Post_Factory(private val postRepository: Post_Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostViewModel::class.java)){
            return PostViewModel(postRepository) as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}