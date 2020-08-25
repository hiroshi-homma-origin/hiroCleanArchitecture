package com.kotlin.project.domain.di

import com.kotlin.project.domain.BuildConfig
import com.kotlin.project.domain.api.PokemonApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(ApplicationComponent::class)
internal object NetworkModule {
    @Provides
    fun providePokemonApi(): PokemonApi {
        val m = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val httpClient = OkHttpClient.Builder()
            .connectTimeout(BuildConfig.API_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(BuildConfig.API_READ_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
        return Retrofit.Builder()
            .baseUrl(BuildConfig.DOMAIN)
            .addConverterFactory(MoshiConverterFactory.create(m))
            .client(httpClient)
            .build()
            .create(PokemonApi::class.java)
    }
}