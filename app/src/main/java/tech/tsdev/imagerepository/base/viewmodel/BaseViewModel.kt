package tech.tsdev.imagerepository.base.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    protected val disposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()

        disposable.dispose()
    }
}