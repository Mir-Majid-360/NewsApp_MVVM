package com.example.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.api.NewsAPI
import com.example.newsapp.api.RetrofitInstance
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.model.Article
import com.example.newsapp.model.NewsList
import com.example.newsapp.repository.NewsRepository
import com.example.newsapp.viewmodel.MainViewModel
import com.example.newsapp.viewmodel.MainViewModelFactory
import com.richReach.helpers.livedatawrapper.Event

class MainActivity : AppCompatActivity() {

    lateinit var  binding: ActivityMainBinding

    lateinit var mainViewModel: MainViewModel
    var list =ArrayList<Article>()

    lateinit var  recyclerView : RecyclerView
    lateinit var newsAdapter : NewsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()


        mainViewModel.newslist.observe(this, Observer<NewsList> {


            binding.progressBar.visibility = View.VISIBLE
            list.clear()
            list.addAll(it.articles!!)

            binding.progressBar.visibility = View.INVISIBLE


            recyclerView = binding.recyclerView
            recyclerView.layoutManager = LinearLayoutManager(this)
            newsAdapter =NewsAdapter(this,list)
            recyclerView.adapter = newsAdapter
            newsAdapter.notifyDataSetChanged()


            //  adapter.not


        })






    }






    private fun initViewModel() {
        val newsAPI = RetrofitInstance.getRetrofitInstance().create(NewsAPI::class.java)
        val repository = NewsRepository(newsAPI)

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)
    }
}