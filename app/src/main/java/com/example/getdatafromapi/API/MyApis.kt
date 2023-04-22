package com.example.getdatafromapi.API

import com.example.getdatafromapi.Response.AlbumData
import retrofit2.Call
import retrofit2.http.GET

interface MyApis {
    @GET("/albums")
    fun getAlbum():Call<AlbumData>

}