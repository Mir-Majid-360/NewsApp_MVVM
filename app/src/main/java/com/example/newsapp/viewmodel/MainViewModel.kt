package com.example.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.api.NewsAPI
import com.example.newsapp.api.RetrofitInstance
import com.example.newsapp.model.NewsList
import com.example.newsapp.repository.NewsRepository
import com.richReach.helpers.livedatawrapper.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Objects

class MainViewModel(private val newsRepository: NewsRepository) :ViewModel(){
  val newslist = MutableLiveData<NewsList>()
    init {

        viewModelScope.launch(Dispatchers.IO) {
            val response=newsRepository.getNews();

            if(response.isSuccessful && response.code()==200) {
                newslist.postValue(response.body())
            }
        }

    }



}