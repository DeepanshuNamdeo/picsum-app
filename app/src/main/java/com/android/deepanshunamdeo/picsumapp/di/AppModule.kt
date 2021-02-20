package com.android.deepanshunamdeo.picsumapp.di

import com.android.deepanshunamdeo.picsumapp.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * this class provides all the dependencies
 * */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providesBaseUrl() : String = "https://picsum.photos/"

    @Provides
    @Singleton
    fun providesRetrofitBuilder(baseUrl :String ):Retrofit =
        Retrofit.Builder()
        .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun providesApiService(retrofit: Retrofit) :ApiService =
        retrofit.create(ApiService::class.java)
}