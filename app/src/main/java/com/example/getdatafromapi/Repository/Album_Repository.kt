package com.example.getdatafromapi.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.getdatafromapi.Album_API.RetroFit_Client
import com.example.getdatafromapi.Response.AlbumData_Response
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Album_Repository {
    val TAG = "AlbumRepository"
    var albumDataList: MutableLiveData<AlbumData_Response> = MutableLiveData()

    fun getAlbum(): LiveData<AlbumData_Response>{
        val call = RetroFit_Client.apiinterface.getAlbum()
        call.enqueue(object: Callback<AlbumData_Response>{
            override fun onResponse(call: Call<AlbumData_Response>, response: Response<AlbumData_Response>) {
                if (response.isSuccessful){
                    val responseData =  response.body()
                    albumDataList.postValue(responseData!!)
                    Log.d(TAG, "onResponse: $responseData")
                }
            }

            override fun onFailure(call: Call<AlbumData_Response>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }

        })
        return albumDataList!!
    }
}