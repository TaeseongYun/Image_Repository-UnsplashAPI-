package tech.tsdev.imagerepository.util

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

fun <T: ViewModel> Class<T>.inject(fragment: Fragment, key: String = "", onCraeteViewModel: () -> T): T =
        ViewModelProviders.of(fragment, onCraeteViewModel).run {
            if ()
        }