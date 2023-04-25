package com.example.getdatafromapi.Repository

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.getdatafromapi.Comments_API.Comment_RetroFit_Client
import com.example.getdatafromapi.Response.comments_Response
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Comments_Repository {
    val commentsDataList: MutableLiveData<comments_Response> = MutableLiveData()
    fun getComments(): LiveData<comments_Response> {
        val call = Comment_RetroFit_Client.Comments_APIS.getComments()
        call.enqueue(object : Callback<comments_Response> {
            override fun onResponse(
                call: Call<comments_Response>,
                response: Response<comments_Response>
            ) {
                val responseData = response.body()
                commentsDataList.postValue(responseData)
                Log.d(ContentValues.TAG, "onResponse: $responseData")
            }

            override fun onFailure(call: Call<comments_Response>, t: Throwable) {
                Log.d(ContentValues.TAG, "onResponse: ${t.message}")
            }

        })
        return commentsDataList
    }
}