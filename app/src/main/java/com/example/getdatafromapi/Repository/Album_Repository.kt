package com.example.getdatafromapi.Repository

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.getdatafromapi.API.RetroFit_Client
import com.example.getdatafromapi.Response.Album
import com.example.getdatafromapi.Response.AlbumData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class Album_Repository {
    val TAG = "AlbumRepository"
    var albumDataList: MutableLiveData<AlbumData> = MutableLiveData()

    fun getAlbum(): LiveData<AlbumData>{
        val call = RetroFit_Client.apiinterface.getAlbum()
        call.enqueue(object: Callback<AlbumData>{
            override fun onResponse(call: Call<AlbumData>, response: Response<AlbumData>) {
                if (response.isSuccessful){
                    val responseData =  response.body()
                    albumDataList.postValue(responseData!!)
                    Log.d(TAG, "onResponse: $responseData")
                }
            }

            override fun onFailure(call: Call<AlbumData>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }

        })
        return albumDataList!!
    }
}