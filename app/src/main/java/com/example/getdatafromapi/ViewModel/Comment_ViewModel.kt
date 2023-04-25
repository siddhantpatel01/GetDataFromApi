package com.example.getdatafromapi.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.getdatafromapi.Repository.Comments_Repository
import com.example.getdatafromapi.Response.comments_Response

class Comment_ViewModel(private val commentsRepository: Comments_Repository):ViewModel() {
    fun getComments():LiveData<comments_Response>{
        return  commentsRepository.getComments()
    }
}