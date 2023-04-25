package com.example.getdatafromapi.Repository

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.getdatafromapi.Post_API.Post_Retrofit_Client
import com.example.getdatafromapi.Response.Post_Response
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Post_Repository {
    val postDataList  : MutableLiveData<Post_Response> = MutableLiveData()

    fun getPost(): LiveData<Post_Response>{

        val call = Post_Retrofit_Client.postApiInterface.getPost()

        call.enqueue(object :Callback<Post_Response>{
            override fun onResponse(call: Call<Post_Response>, response: Response<Post_Response>) {
                if(response.isSuccessful){
                    val responseData = response.body()
                    postDataList.postValue(responseData)
                    Log.d(TAG, "onResponse: $responseData")
                }
            }

            override fun onFailure(call: Call<Post_Response>, t: Throwable) {
                Log.d(TAG, "onResponse: ${t.message}")
            }

        })
        return postDataList
    }
}