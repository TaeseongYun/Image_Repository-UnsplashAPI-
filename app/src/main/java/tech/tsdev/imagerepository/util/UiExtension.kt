package tech.tsdev.imagerepository.util

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

inline fun AppCompatActivity.createFragment(@IdRes fragmentID: Int, fragment: Fragment) =
        supportFragmentManager.beginTransaction().run {
                this.replace(fragmentID, fragment)
        }.commit()