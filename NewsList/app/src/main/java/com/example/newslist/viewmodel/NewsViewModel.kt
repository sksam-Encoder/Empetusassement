package com.example.newslist.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.newslist.common.ScreenState
import com.example.newslist.data.RetrofitInstance
import com.example.newslist.data.dto.NewsModel
import com.example.newslist.data.repositories.NewsRepository
import com.example.newslist.listeners.Receiver
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NewsViewModel : BaseViewModel<NewsModel>() {
    val repos = NewsRepository()
    var change by mutableStateOf(1)
    var title by mutableStateOf("")
    var search by mutableStateOf("")

    fun getNews() {
        _state.value = ScreenState(isLoading = true)
        repos.getNews().onEach {
            _state.value = ScreenState(receivedResponse = it)
        }.launchIn(viewModelScope)
    }

//    suspend fun getNewsFromApi(): Flow<String> = flow{
//        val apiServices = RetrofitInstance.getInstance()
//        val news = apiServices.getNews()
//        emit(news)
//    }
}