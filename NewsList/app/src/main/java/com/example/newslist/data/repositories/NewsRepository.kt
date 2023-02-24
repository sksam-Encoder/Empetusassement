package com.example.newslist.data.repositories

import com.example.newslist.data.RetrofitInstance
import com.example.newslist.data.dto.NewsModel
import com.example.newslist.listeners.Receiver
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepository {
    fun getNews() : Flow<NewsModel> = flow {
        val apiServices = RetrofitInstance.getInstance()
        val news = apiServices.getNews()
        emit(news)
    }
}