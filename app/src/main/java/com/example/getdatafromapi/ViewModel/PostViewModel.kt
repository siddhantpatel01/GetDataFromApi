package com.example.getdatafromapi.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.getdatafromapi.Repository.Post_Repository
import com.example.getdatafromapi.Response.Post_Response

class PostViewModel(private val postRepository: Post_Repository):ViewModel() {

    fun getPost():LiveData<Post_Response>{
        return postRepository.getPost()
    }
}