package tech.tsdev.imagerepository.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import tech.tsdev.imagerepository.data.source.UnsplashRepository
import tech.tsdev.imagerepository.databinding.ImageListFragmentBinding
import tech.tsdev.imagerepository.network.RetrofitObject
import tech.tsdev.imagerepository.ui.adapter.ImageRecyclerAdapter
import tech.tsdev.imagerepository.ui.viewmodel.ImageListFragmentViewModel
import tech.tsdev.imagerepository.util.inject

class ImageListFragment : Fragment() {

    private val imageListAdapter: ImageRecyclerAdapter by lazy {
        ImageRecyclerAdapter(this.context)
    }
    private val unsplashRepository: UnsplashRepository
    get() =
        UnsplashRepository.getInstance(RetrofitObject.getAPI)

    private val imageListFragmentViewModel: ImageListFragmentViewModel by lazy(LazyThreadSafetyMode.NONE) {
        ImageListFragmentViewModel::class.java.inject(this) {
            ImageListFragmentViewModel(unsplashRepository, imageListAdapter)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = ImageListFragmentBinding.inflate(inflater, container, false)
        binding.imageList.run {
            adapter = imageListAdapter
            layoutManager = GridLayoutManager(this.context, 1)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageListFragmentViewModel.loadImageList(0, 50)
    }
}