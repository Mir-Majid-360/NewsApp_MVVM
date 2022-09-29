package com.example.newsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.model.Article
import com.example.newsapp.model.NewsList
import com.squareup.picasso.Picasso

class NewsAdapter(var context: Context, val articles:  ArrayList<Article> ) : RecyclerView.Adapter<NewsAdapter.MyViewHolder>(){





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(articles.get(position))


    }

    override fun getItemCount(): Int {

        return articles.size
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val newsImage : ImageView = view.findViewById(R.id.ivNews)
        val tvHeading :TextView = view.findViewById(R.id.tvNewsHeading)
        val tvContent : TextView = view.findViewById(R.id.tvSubHeading)


        fun bind(data :Article){

            tvHeading.text = data.title
            tvContent.text = data.content
            val url = data.urlToImage
            Picasso.get()
                .load(url)
                .into(newsImage)

        }

    }

}

