package com.example.newsapp.api


import retrofit2.http.GET
import com.example.newsapp.model.NewsList
import retrofit2.Response

interface NewsAPI {

    @GET("/v2/top-headlines?country=in&apiKey=ed33af01dca6426bb5a4067179f53057")
    suspend fun getDataFromApi(): Response<NewsList>
}