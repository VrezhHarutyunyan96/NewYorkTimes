package com.android.weatherapp.nextstack.nytimes.ui.home.viewmodel.repository

import com.android.weatherapp.nextstack.nytimes.ui.home.model.NewsResponseModel
import com.android.weatherapp.nextstack.nytimes.ui.home.viewmodel.dataSource.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class HomeRepositoryImpl(
    private val dataSource: RemoteDataSource
) : HomeRepository {

    override suspend fun loadNewsFeed(apiKey: String): Flow<NewsResponseModel> {
        return flow {
            val data = dataSource.getNews(apiKey)
            emit(data)
        }.flowOn(Dispatchers.IO)
    }

}