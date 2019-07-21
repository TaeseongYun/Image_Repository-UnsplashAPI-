package tech.tsdev.imagerepository.util

import io.reactivex.internal.schedulers.RxThreadFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

fun <T> createRetrofit(cls: Class<T>, baseUrl: String): T =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpInterceptor())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(cls)

fun okHttpInterceptor(): OkHttpClient =
    OkHttpClient.Builder().addInterceptor(
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build()