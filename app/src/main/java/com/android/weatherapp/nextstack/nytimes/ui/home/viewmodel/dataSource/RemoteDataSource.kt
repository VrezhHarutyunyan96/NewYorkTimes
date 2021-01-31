package com.android.weatherapp.nextstack.nytimes.ui.home.viewmodel.dataSource

import com.android.weatherapp.nextstack.nytimes.data.remote.ApiService

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getNews(apiKey: String) = apiService.getNews(apiKey)

}