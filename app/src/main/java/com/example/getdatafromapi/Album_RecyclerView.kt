package com.example.getdatafromapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.getdatafromapi.Adapter.Album_Adapter
import com.example.getdatafromapi.Adapter.Post_Adapter
import com.example.getdatafromapi.Factory.AlbumFactory
import com.example.getdatafromapi.Factory.Post_Factory
import com.example.getdatafromapi.Repository.Album_Repository
import com.example.getdatafromapi.Repository.Post_Repository
import com.example.getdatafromapi.ViewModel.AlbumViewModel
import com.example.getdatafromapi.ViewModel.PostViewModel
import com.example.getdatafromapi.databinding.ActivityAlbumRecyclerViewBinding
import okhttp3.internal.notify

class Album_RecyclerView : AppCompatActivity() {

    lateinit var binding: ActivityAlbumRecyclerViewBinding

    lateinit var factory: AlbumFactory
    lateinit var viewModel: AlbumViewModel
    lateinit var adapter: Album_Adapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this , R.layout.activity_album_recycler_view)

        //factory = AlbumFactory(Album_Repository())

//        viewModel = ViewModelProvider(this,
//            ViewModelProvider.AndroidViewModelFactory.getInstance(application))[AlbumViewModel::class.java]

        factory = AlbumFactory(Album_Repository())
        viewModel = ViewModelProvider(this, factory)[AlbumViewModel::class.java]
        binding.lifecycleOwner = this

        binding.apiDataField.layoutManager = LinearLayoutManager(this)

        viewModel.getAlbum().observe(this, Observer {
            adapter = Album_Adapter(it)
            binding.apiDataField.adapter = adapter
            adapter.notifyDataSetChanged()
        })





    }
}