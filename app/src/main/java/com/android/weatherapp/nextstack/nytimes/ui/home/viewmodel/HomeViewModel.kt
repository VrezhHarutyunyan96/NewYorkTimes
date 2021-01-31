package com.android.weatherapp.nextstack.nytimes.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.weatherapp.nextstack.nytimes.BuildConfig
import com.android.weatherapp.nextstack.nytimes.ui.home.model.NewsResponseModel
import com.android.weatherapp.nextstack.nytimes.ui.home.viewmodel.repository.HomeRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val newsFeedMutableLiveData: MutableLiveData<NewsResponseModel> by lazy {
        return@lazy MutableLiveData()
    }

    init {
        loadFromApi(BuildConfig.API_KEY)
    }

    fun loadFromApi(apiKey: String) = viewModelScope.launch {
        homeRepository.loadNewsFeed(apiKey).collect {
            newsFeedMutableLiveData.value = it
        }
    }

    fun getNewsFeedLiveData(): LiveData<NewsResponseModel> = newsFeedMutableLiveData

}