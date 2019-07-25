package tech.tsdev.imagerepository.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import tech.tsdev.imagerepository.R
import tech.tsdev.imagerepository.data.source.UnsplashRepository
import tech.tsdev.imagerepository.network.RetrofitObject
import tech.tsdev.imagerepository.ui.adapter.ImageRecyclerAdapter
import tech.tsdev.imagerepository.ui.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private val imageRecyclerAdapter: ImageRecyclerAdapter by lazy {
        ImageRecyclerAdapter(this)
    }

    private val imageRepository: UnsplashRepository
        get() = UnsplashRepository.getInstance(RetrofitObject.getAPI)

    private val mainActivity: MainActivityViewModel by lazy(LazyThreadSafetyMode.NONE) {
        MainActivityViewModel::class.java.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        mainActivity.loadImageList(0, 50)

        recycler_view.run {
            adapter = imageRecyclerAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 1)
        }
    }
}
