package com.android.weatherapp.nextstack.nytimes.data.remote

import com.android.weatherapp.nextstack.nytimes.ui.home.model.NewsResponseModel
import com.android.weatherapp.nextstack.nytimes.utils.ConstantsUtil.END_POINT
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(END_POINT)
    suspend fun getNews(
        @Query("api-key") apiKey: String
    ): NewsResponseModel
}