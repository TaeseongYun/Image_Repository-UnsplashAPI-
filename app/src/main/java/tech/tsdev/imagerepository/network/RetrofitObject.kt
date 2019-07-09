package tech.tsdev.imagerepository.network

import tech.tsdev.imagerepository.util.createRetrofit

object RetrofitObject {

    const val UNSPLASH_URL = "https://api.unsplash.com"

    val getAPI: UnsplashAPI by lazy {
        createRetrofit(UnsplashAPI::class.java, UNSPLASH_URL)
    }
}