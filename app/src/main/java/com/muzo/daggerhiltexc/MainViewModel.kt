package com.muzo.daggerhiltexc

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel@Inject constructor(private val repository: RetrofitRepository):ViewModel() {

    private var liveData: MutableLiveData<List<Post>> = MutableLiveData()


    fun observeLiveData():MutableLiveData<List<Post>>{
        return liveData
    }

    fun loadData(){
        repository.getPosts(liveData)
    }

}