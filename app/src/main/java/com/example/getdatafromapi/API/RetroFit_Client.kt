package com.example.getdatafromapi.API

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val baseurl = "https://jsonplaceholder.typicode.com"

object RetroFit_Client {

    val retofitClient: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
    }
    val apiinterface:MyApis by lazy {
        retofitClient.build().create(MyApis::class.java)
    }
}