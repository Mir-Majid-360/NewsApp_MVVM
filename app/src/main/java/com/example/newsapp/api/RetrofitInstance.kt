package com.example.newsapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {



    companion object{
       const val BASE_URL = "https://newsapi.org"
        fun getRetrofitInstance():Retrofit{
             return  Retrofit.Builder()
                 .baseUrl(BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create())
                 .build()


        }

    }


}