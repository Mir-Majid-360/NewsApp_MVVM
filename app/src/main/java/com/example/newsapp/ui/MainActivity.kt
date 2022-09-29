package com.example.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.newsapp.R
import com.example.newsapp.api.NewsAPI
import com.example.newsapp.api.RetrofitInstance
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.repository.NewsRepository
import com.example.newsapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var  binding: ActivityMainBinding

    lateinit var mainViewModel: MainViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        observeViewModel()
        mainViewModel.setOpenHomeFragment(arrayOf(1,2))

    }

    private fun observeViewModel() {

        mainViewModel.getOpenHomeFragment().observe(this) { event ->
            val objects: Array<Any>? = event.getContentIfNotHandled()
            if (objects != null) {
                openFragment(HomeFragment.newInstance(), "")
            }
        }
    }
    private fun openFragment(fragment: Fragment, tag: String) {
        val transaction = supportFragmentManager.beginTransaction()
        setFragmentTransactionAnimation(transaction, tag)
        transaction.replace(R.id.main_container, fragment, tag)
        transaction.addToBackStack(tag)
        transaction.commit()
    }
    private fun setFragmentTransactionAnimation(transaction: FragmentTransaction, tag: String) {
        transaction.setCustomAnimations(
            R.anim.enter_from_right,
            R.anim.exit_to_left,
            R.anim.enter_from_left,
            R.anim.exit_to_right
        )
    }





    private fun initViewModel() {

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }
}