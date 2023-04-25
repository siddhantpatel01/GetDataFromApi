package com.example.getdatafromapi.Post_API

import com.example.getdatafromapi.Response.AlbumData_Response
import com.example.getdatafromapi.Response.Post_Response
import retrofit2.Call
import retrofit2.http.GET

interface PostApi {
    @GET("/posts")
    fun getPost(): Call<Post_Response>

}