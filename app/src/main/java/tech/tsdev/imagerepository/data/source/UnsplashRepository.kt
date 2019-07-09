package tech.tsdev.imagerepository.data.source

import tech.tsdev.imagerepository.network.UnsplashAPI

class UnsplashRepository private constructor(unsplashAPI: UnsplashAPI) {

    companion object {

        // 싱글톤 패턴
        private val instance: UnsplashRepository? = null

        fun getInstance(unsplashAPI: UnsplashAPI) {
            instance ?: synchronized(this) {
                instance ?: UnsplashRepository(unsplashAPI)
            }
        }
    }

    private val unsplashRemoteData: UnsplashRemoteData by lazy {
        UnsplashRemoteData(unsplashAPI)
    }

    fun getLoadImages(page: Int, perPage: Int)
            = unsplashRemoteData.getLoadImages(page, perPage)
}