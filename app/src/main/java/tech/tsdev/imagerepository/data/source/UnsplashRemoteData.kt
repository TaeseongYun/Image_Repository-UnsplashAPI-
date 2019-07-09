package tech.tsdev.imagerepository.data.source

import tech.tsdev.imagerepository.network.UnsplashAPI

class UnsplashRemoteData(val unsplashAPI: UnsplashAPI) {

    fun getLoadImages(page: Int, perPage: Int) =
            unsplashAPI.getLoadImages(page, perPage)
}