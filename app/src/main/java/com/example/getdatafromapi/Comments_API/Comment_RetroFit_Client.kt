package com.example.getdatafromapi.Comments_API

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val baseurl  = "https://jsonplaceholder.typicode.com"
object Comment_RetroFit_Client {

    val Comment_RetroFit_Client : Retrofit.Builder by lazy {
        Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))

    }
    val Comments_APIS : Comment_API by lazy {
        Comment_RetroFit_Client.build().create(Comment_API::class.java)
    }
}