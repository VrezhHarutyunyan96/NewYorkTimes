package com.android.weatherapp.nextstack.nytimes.di

import com.android.weatherapp.nextstack.nytimes.BuildConfig
import com.android.weatherapp.nextstack.nytimes.data.remote.ApiService
import com.android.weatherapp.nextstack.nytimes.ui.details.viewmodel.DetailsSharedVIewModel
import com.android.weatherapp.nextstack.nytimes.ui.home.viewmodel.HomeViewModel
import com.android.weatherapp.nextstack.nytimes.ui.home.viewmodel.dataSource.RemoteDataSource
import com.android.weatherapp.nextstack.nytimes.ui.home.viewmodel.repository.HomeRepository
import com.android.weatherapp.nextstack.nytimes.ui.home.viewmodel.repository.HomeRepositoryImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Koin Module
 * */

private const val TIME_OUT = 30L

val networkModule = module {
    single { createRetrofit(get(), BuildConfig.BASE_URL) }
    single { createOkHttpClient() }
    single { createService(get()) }

}

val dataSourceModule = module {
    single { provideRemoteDataSource(get()) }
}

val repoModule = module {
    single { provideHomeRepository(get()) }
}

val presentationModule = module {
    viewModel { provideHomeViewModel(get()) }
    viewModel { provideNewsDetailsSharedViewModel() }
}

private fun provideNewsDetailsSharedViewModel(): DetailsSharedVIewModel {
    return DetailsSharedVIewModel()
}

private fun provideHomeViewModel(homeRepository: HomeRepository): HomeViewModel {
    return HomeViewModel(homeRepository)
}

private fun provideHomeRepository(
    remoteDataSource: RemoteDataSource,
): HomeRepository {
    return HomeRepositoryImpl(remoteDataSource)
}

private fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource {
    return RemoteDataSource(apiService)
}


fun createOkHttpClient(): OkHttpClient {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    return OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        .build()
}

fun createRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            )
        )
        .baseUrl(url)
        .client(okHttpClient)
        .build()
}


fun createService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}

