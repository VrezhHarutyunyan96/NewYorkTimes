package com.android.weatherapp.nextstack.nytimes.ui.home.viewmodel.repository

import com.android.weatherapp.nextstack.nytimes.ui.home.model.NewsResponseModel
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun loadNewsFeed(apiKey: String): Flow<NewsResponseModel>
}