package tech.tsdev.imagerepository.ui


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import tech.tsdev.imagerepository.R
import tech.tsdev.imagerepository.databinding.ActivityMainBinding
import tech.tsdev.imagerepository.ui.fragment.ImageFavoriteFragment
import tech.tsdev.imagerepository.ui.fragment.ImageListFragment
import tech.tsdev.imagerepository.util.createFragment


class MainActivity : AppCompatActivity() {

    private val imageListFragment: ImageListFragment by lazy {
        ImageListFragment()
    }

    private val imageFavoriteFragment: ImageFavoriteFragment by lazy {
        ImageFavoriteFragment()
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.image_bottom -> {
                    imageListFragment.createView()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.favorite_bottom -> {
                    imageFavoriteFragment.createView()
                    Log.d("FAVORITE", "click!")
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener (mOnNavigationItemSelectedListener)

        imageListFragment.createView()
        binding.root
    }

    private fun Fragment.createView() {
        createFragment(R.id.container, this)
    }
}
