package com.muzo.daggerhiltexc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muzo.daggerhiltexc.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter: PostAdapter
    private var postList= arrayListOf<Post>()

    val viewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.observeLiveData().observe(this,object :Observer<List<Post>>{
            override fun onChanged(t: List<Post>?) {
                if (t !=null){
                    postList.addAll(t)
                    adapter= PostAdapter(postList)
                }
                binding.recyclerView.adapter=adapter

            }
        })

        viewModel.loadData()


    }
}