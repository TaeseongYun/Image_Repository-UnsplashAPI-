package tech.tsdev.imagerepository.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders



//powered by taehwandev github
fun <T: ViewModel> Class<T>.inject(fragment: Fragment, tag: String = "", onCreateViewModelFactory: () -> T): T =
    ViewModelProviders.of(fragment, onCreateFactory(onCreateViewModelFactory)).run {
        if(tag.isNotEmpty())
            this.get(tag, this@inject)
        else
            get(this@inject)
    }

fun <T: ViewModel> Class<T>.inject(activity: FragmentActivity, tag: String = "", onCreateViewModelFactory: () -> T): T =
    ViewModelProviders.of(activity, onCreateFactory(onCreateViewModelFactory)).run {
        if(tag.isNotEmpty())
            get(tag, this@inject)
        else
            get(this@inject)
    }

private fun<T> onCreateFactory(onCreateViewModel: () -> T) = object : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return onCreateViewModel() as T
    }

}