package tech.tsdev.imagerepository.viewmodel


import androidx.lifecycle.ViewModel
import tech.tsdev.imagerepository.network.UnsplashAPI

class MainActivityViewModel(val unsplashAPI: UnsplashAPI) : ViewModel() {


    override fun onCleared() {
        super.onCleared()
    }

}