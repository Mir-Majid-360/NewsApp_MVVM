package com.example.newsapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.api.NewsAPI
import com.example.newsapp.model.NewsList
import retrofit2.Response

class NewsRepository(private val newsService: NewsAPI) {

    suspend fun getNews():Response<NewsList>{
       return newsService.getDataFromApi()
    }


}