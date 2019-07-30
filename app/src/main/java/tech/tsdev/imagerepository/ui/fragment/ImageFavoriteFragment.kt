package tech.tsdev.imagerepository.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import tech.tsdev.imagerepository.databinding.ImageFavoriteFragmentBinding

class ImageFavoriteFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding =
            ImageFavoriteFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }
}