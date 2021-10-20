package com.byfitnation.newsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val context: Context , val articles : List<Article>):
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_list_items , parent , false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]

        holder.newsTitle.text = article.title
        holder.newsDescription.text = article.description
    }

    override fun getItemCount(): Int {
        return articles.size
    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        var newsImage : ImageView = itemView.findViewById(R.id.ivNewsImage)
        var newsTitle : TextView = itemView.findViewById(R.id.tvNewsTitle)
        var newsDescription : TextView = itemView.findViewById(R.id.tvNewsDescription)
        var newsSource : TextView = itemView.findViewById(R.id.tvNewsSource)
    }
}