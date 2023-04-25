package com.example.getdatafromapi.Comments_API

import com.example.getdatafromapi.Response.comments_Response
import retrofit2.Call
import retrofit2.http.GET


interface Comment_API {
    @GET("/comments")
    fun getComments(): Call<comments_Response>
}