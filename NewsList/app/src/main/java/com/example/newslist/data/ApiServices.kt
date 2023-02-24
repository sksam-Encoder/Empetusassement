package com.example.newslist.data

import android.database.Observable
import com.example.newslist.data.dto.NewsModel
import retrofit2.http.GET

interface ApiServices {
    @GET("v3/articles/")
    suspend fun getNews(): NewsModel

}