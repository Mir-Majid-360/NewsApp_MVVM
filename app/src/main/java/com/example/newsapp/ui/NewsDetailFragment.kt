package com.example.newsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentNewsDetailBinding
import com.example.newsapp.model.Article
import com.example.newsapp.viewmodel.MainViewModel

class NewsDetailFragment : Fragment() {

    lateinit var binding: FragmentNewsDetailBinding

    lateinit var mainViewModel: MainViewModel
    var list =ArrayList<Article>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentNewsDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            NewsDetailFragment()
    }
}