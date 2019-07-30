package tech.tsdev.imagerepository.ui.adapter.holder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.image_recycler_detail.view.*
import tech.tsdev.imagerepository.R
import tech.tsdev.imagerepository.data.UnsplashResponse

class ImageRecyclerHolder(context: Context?, parent: ViewGroup) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.image_recycler_detail, parent, false)
    ) {

    fun onBind(items: UnsplashResponse) {
        itemView.onBind(items)
    }

    private fun View.onBind(items: UnsplashResponse) {

        tv_username.text = items.user.username
        img_user.getloadProfileImage(items.user.profile_image.medium)
        img_userUpload.getLoadImage(items.urls.full)
    }
}