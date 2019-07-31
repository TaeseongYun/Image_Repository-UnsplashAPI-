package tech.tsdev.imagerepository.ui.viewmodel


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import tech.tsdev.imagerepository.base.viewmodel.BaseViewModel
import tech.tsdev.imagerepository.base.viewmodel.baseAdaper.BaseViewHolder
import tech.tsdev.imagerepository.data.UnsplashResponse
import tech.tsdev.imagerepository.data.source.UnsplashRepository
import tech.tsdev.imagerepository.ui.MainActivity
import tech.tsdev.imagerepository.util.plusAssign

class ImageListFragmentViewModel(
    private val unsplashRepository: UnsplashRepository,
    private val imageRecyclerModel: BaseViewHolder<UnsplashResponse>
) : BaseViewModel() {


    fun loadImageList(page: Int, perPage: Int) {
        disposable += unsplashRepository.getLoadImages(page, perPage)
            .subscribeOn(Schedulers.io())
//            .unsubscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.forEach { unsplashItem ->
                    imageRecyclerModel.addItems(unsplashItem)
                }
                imageRecyclerModel.notifyedItemChange()
            }, {})
    }

    fun viewModelOnClickListener(adapterPosition: Int, view: AppCompatActivity) {
        imageRecyclerModel.getItems(adapterPosition).let {
            view.startActivity(Intent(view, MainActivity::class.java))
        }
    }

}