package tech.tsdev.imagerepository.util

import android.content.Context
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import tech.tsdev.imagerepository.R

class GlideImageView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ImageView(context, attrs, defStyleAttr) {

    fun getLoadImage(baseUrl: String, @DrawableRes replaceImage: Int = R.drawable.ic_launcher_background) {
        Glide.with(this)
            .load(baseUrl)
            .placeholder(replaceImage)
            .apply(RequestOptions.centerCropTransform())
            .into(this)
    }
}