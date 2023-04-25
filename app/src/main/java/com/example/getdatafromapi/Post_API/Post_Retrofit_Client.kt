package com.example.getdatafromapi.Post_API

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

const val baserl = "https://jsonplaceholder.typicode.com"

object Post_Retrofit_Client {
    val Post_Retrofit_Client : Retrofit.Builder by lazy {
        Retrofit.Builder().baseUrl(baserl).addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
    }

    val postApiInterface : PostApi by lazy {
        Post_Retrofit_Client.build().create(PostApi::class.java)
    }
}