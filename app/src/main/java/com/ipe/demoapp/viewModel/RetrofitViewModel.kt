package com.ipe.demoapp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipe.demoapp.model.Post
import com.ipe.demoapp.repository.ApiInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitViewModel : ViewModel() {

     var _posts1: MutableLiveData<List<Post>> = MutableLiveData()


    fun _posts(): LiveData<List<Post>>  = _posts1
    val _postList : LiveData<List<Post>> get() = _posts1

    var count: Int = 0

    fun increaseValue(){
        count += 1
    }

    fun getData(){
        viewModelScope.launch {
            val apiInterface = ApiInterface.create()
            with(apiInterface) {

                getPost().enqueue(object : Callback<List<Post>> {
                    override fun onResponse(
                        call: Call<List<Post>>,
                        response: Response<List<Post>>
                    ) {
                        if (response.isSuccessful) {
                            _posts1.value = response.body()
                        }
                    }

                    override fun onFailure(call: Call<List<Post>>, t: Throwable) {

                    }
                })
            }

        }
    }
    init {
        Log.i("Retrofit ","Init Block")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("Retrofit ","onCleared")
    }
}