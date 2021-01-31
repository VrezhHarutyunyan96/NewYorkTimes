package com.android.weatherapp.nextstack.nytimes.ui.details.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.weatherapp.nextstack.nytimes.ui.home.model.NewsResponseModel

class DetailsSharedVIewModel : ViewModel() {

    private val newsSharedMutableLiveData: MutableLiveData<NewsResponseModel.ResultsItem> by lazy {
        return@lazy MutableLiveData<NewsResponseModel.ResultsItem>()
    }

    fun setNews(newsItem: NewsResponseModel.ResultsItem) {
        newsSharedMutableLiveData.value = newsItem
    }

    fun getNews(): LiveData<NewsResponseModel.ResultsItem> = newsSharedMutableLiveData
}