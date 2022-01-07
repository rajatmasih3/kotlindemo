package com.ipe.demoapp.repository

import com.ipe.demoapp.model.Post
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("posts")
    fun getPost(): Call<List<Post>>

    companion object {
        const val baseUrl = "https://jsonplaceholder.typicode.com/"

        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}