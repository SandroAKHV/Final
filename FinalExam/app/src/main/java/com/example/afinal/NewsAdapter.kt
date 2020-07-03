package com.example.afinal

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_item.view.*

class NewsAdapter(private var news: List<News> )
    : RecyclerView.Adapter<NewsAdapter.NewsAdapterViewHolder>() {

    class NewsAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n")
        fun bind(newsItem: News) {

            itemView.newsTitle.text = "Title: ${newsItem.title}"
            itemView.newsDesc.text = "Description: ${newsItem.description}"
            itemView.newsURL.text = "URL: ${newsItem.url}"

            Picasso.get().load(newsItem.image).into(itemView.newsImageView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapterViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return NewsAdapterViewHolder(v)
    }

    override fun getItemCount(): Int = news.size

    override fun onBindViewHolder(holder: NewsAdapterViewHolder, position: Int) {
        holder.bind(news[position])
    }

    fun updateNews(news: List<News>) {
        this.news = news
        notifyDataSetChanged()
    }
}