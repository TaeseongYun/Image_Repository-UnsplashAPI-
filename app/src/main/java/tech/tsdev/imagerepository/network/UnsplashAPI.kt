package tech.tsdev.imagerepository.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import tech.tsdev.imagerepository.BuildConfig
import tech.tsdev.imagerepository.data.UnsplashResponse

interface UnsplashAPI {

    @GET("/photos/?client_id=${BuildConfig.UNSPLASH_KEY}")
    fun getLoadImages(

        @Query("page") page: Int,

        @Query("per_page") perPage: Int
    ): Call<UnsplashResponse>
}