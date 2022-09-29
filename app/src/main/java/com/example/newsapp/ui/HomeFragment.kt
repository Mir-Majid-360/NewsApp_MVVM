package com.example.newsapp.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.api.NewsAPI
import com.example.newsapp.api.RetrofitInstance
import com.example.newsapp.databinding.FragmentHomeBinding
import com.example.newsapp.model.Article
import com.example.newsapp.model.NewsList
import com.example.newsapp.repository.NewsRepository
import com.example.newsapp.viewmodel.MainViewModel
import com.example.newsapp.viewmodel.MainViewModelFactory

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    lateinit var mainViewModel: MainViewModel
    var list = ArrayList<Article>()

    lateinit var recyclerView: RecyclerView
    lateinit var newsAdapter: NewsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()
        initViewModel()
        initAdapter()


        //  adapter.no

    }

    fun initAdapter() {



        mainViewModel.newslist.observe(viewLifecycleOwner, Observer<NewsList> {


            list.clear()
            list.addAll(it.articles!!)
            recyclerView = binding.recyclerView
            newsAdapter = NewsAdapter(activity as Context, list)
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView = binding.recyclerView
            recyclerView.adapter = newsAdapter
            newsAdapter.notifyDataSetChanged()

        })
    }


    companion object {


        @JvmStatic
        fun newInstance() =
            HomeFragment()

    }

    private fun setListeners() {
    }



    private fun initViewModel() {


        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }
}