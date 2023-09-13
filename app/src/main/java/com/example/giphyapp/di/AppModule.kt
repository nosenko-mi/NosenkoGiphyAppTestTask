package com.example.giphyapp.di

import com.example.giphyapp.common.Constants
import com.example.giphyapp.data.remote.GiphyApi
import com.example.giphyapp.data.repository.GiphyRepositoryImpl
import com.example.giphyapp.domain.repository.GiphyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGiphyApi(): GiphyApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GiphyApi::class.java)
    }

    @Provides
    @Singleton
    fun providesGiphyRepository(api: GiphyApi): GiphyRepository{
        return GiphyRepositoryImpl(api)
    }
}