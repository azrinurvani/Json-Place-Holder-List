package com.azrinurvani.axatest.di

import android.util.Log
import com.azrinurvani.axatest.domain.source.ApiService
import com.azrinurvani.axatest.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient() : OkHttpClient{
        val interceptor = HttpLoggingInterceptor{ message->
            Log.d("API", "log: $message")
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(Constants.CONNECT_TIME_OUT,TimeUnit.SECONDS)
            .readTimeout(Constants.READ_TIME_OUT,TimeUnit.SECONDS)
            .callTimeout(Constants.CALL_TIME_OUT,TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitBuilder(httpClient: OkHttpClient) : Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) : ApiService{
        return retrofit.create(ApiService::class.java)
    }

}