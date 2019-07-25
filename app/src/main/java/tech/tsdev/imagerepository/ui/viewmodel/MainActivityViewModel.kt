package tech.tsdev.imagerepository.ui.viewmodel


import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import tech.tsdev.imagerepository.base.viewmodel.BaseViewModel
import tech.tsdev.imagerepository.base.viewmodel.baseAdaper.BaseAdapter
import tech.tsdev.imagerepository.data.UnsplashResponse
import tech.tsdev.imagerepository.data.source.UnsplashRepository
import tech.tsdev.imagerepository.util.plusAssign

class MainActivityViewModel(
    private val unsplashRepository: UnsplashRepository,
    private val imageRecyclerModel: BaseAdapter<UnsplashResponse>
) : BaseViewModel() {


    fun loadImageList(page: Int, perPage: Int) {
        disposable += unsplashRepository.getLoadImages(page, perPage)
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.forEach { unsplashItem ->
                    imageRecyclerModel.addItems(unsplashItem)
                }
                imageRecyclerModel.notifyedItemChange()
            }, {})
    }


}