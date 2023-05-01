package com.example.getdatafromapi.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.getdatafromapi.Repository.Album_Repository
import com.example.getdatafromapi.Response.AlbumData_Response

class AlbumViewModel(private val albumRepository: Album_Repository) : ViewModel() {
    fun getAlbum(): LiveData<AlbumData_Response>{
        return albumRepository.getAlbum()
    }
}
