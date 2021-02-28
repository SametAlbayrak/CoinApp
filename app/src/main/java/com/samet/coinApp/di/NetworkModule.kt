package com.samet.coinApp.di

import com.samet.coinApp.api.ApiService
import com.samet.coinApp.util.Constant.API_KEY
import com.samet.coinApp.util.Constant.API_KEY_VALUE
import com.samet.coinApp.util.Constant.BASE_URL
import com.samet.coinApp.util.Constant.LANGUAGE
import com.samet.coinApp.util.Constant.LANGUAGE_VALUE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@InstallIn(ApplicationComponent::class)
@Module
object NetworkModule {


    @Provides
    fun provideBaseUrl(): String {
        return BASE_URL
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor { chain ->
            val request = chain.request().newBuilder()
            val originalHttpUrl = chain.request().url
            val url = originalHttpUrl.newBuilder().addQueryParameter(LANGUAGE, LANGUAGE_VALUE)
                .addQueryParameter(API_KEY, API_KEY_VALUE).build()
            request.url(url)
            request.addHeader("X-CMC_PRO_API_KEY", "103725a7-8317-4e13-86eb-7cdc288f51ce")
            return@addInterceptor chain.proceed(request.build())
        }
            .callTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun provideRetrofit(
        baseUrl: String,
        converterFactory: Converter.Factory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }
}