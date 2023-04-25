package com.example.getdatafromapi.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.getdatafromapi.Repository.Comments_Repository
import com.example.getdatafromapi.Repository.Post_Repository
import com.example.getdatafromapi.ViewModel.Comment_ViewModel
import com.example.getdatafromapi.ViewModel.PostViewModel

class Comments_Factory(private val commentsRepository: Comments_Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(Comment_ViewModel::class.java)){
            return Comment_ViewModel(commentsRepository) as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}