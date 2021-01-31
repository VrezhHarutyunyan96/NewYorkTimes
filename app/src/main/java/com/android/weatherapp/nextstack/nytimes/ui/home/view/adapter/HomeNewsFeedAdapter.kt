package com.android.weatherapp.nextstack.nytimes.ui.home.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.weatherapp.nextstack.nytimes.databinding.ItemNewsFeedBinding
import com.android.weatherapp.nextstack.nytimes.ui.home.model.NewsResponseModel

class HomeNewsFeedAdapter(private val onClick: (newsDetail: NewsResponseModel.ResultsItem) -> Unit) :
    RecyclerView.Adapter<HomeNewsFeedAdapter.HomeNewsFeedViewHolder>() {

    private lateinit var newsFeed: NewsResponseModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeNewsFeedViewHolder {
        val binding = ItemNewsFeedBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeNewsFeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeNewsFeedViewHolder, position: Int) {
        newsFeed.results?.get(position)?.let { holder.bind(it, onClick) }
    }

    override fun getItemCount(): Int {
        return newsFeed.results?.size ?: 0
    }

    fun setNewsFeed(newsFeed: NewsResponseModel) {
        this.newsFeed = newsFeed
        notifyDataSetChanged()
    }

    class HomeNewsFeedViewHolder(private val binding: ItemNewsFeedBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            newsItem: NewsResponseModel.ResultsItem,
            onClick: (newsDetail: NewsResponseModel.ResultsItem) -> Unit
        ) {

            binding.cardOnClick = onClick
            binding.newsItem = newsItem
            binding.url = newsItem.media?.get(0)?.mediaMetadata?.get(0)?.url

        }
    }
}