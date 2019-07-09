package tech.tsdev.imagerepository.util

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun <T> createRetrofit(cls: Class<T>, baseUrl: String): T =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpInterceptor())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(cls)

fun okHttpInterceptor(): OkHttpClient =
    OkHttpClient.Builder().addInterceptor(
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build()