package com.example.getdatafromapi.Album_API

import com.example.getdatafromapi.Response.AlbumData_Response
import retrofit2.Call
import retrofit2.http.GET

interface MyApis {
    @GET("/albums")
    fun getAlbum():Call<AlbumData_Response>

}