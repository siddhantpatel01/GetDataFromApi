package com.example.getdatafromapi.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.getdatafromapi.Repository.Album_Repository
import com.example.getdatafromapi.ViewModel.AlbumViewModel

class AlbumFactory(private val albumRepository: Album_Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlbumViewModel::class.java)){
            return AlbumViewModel(albumRepository) as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}
