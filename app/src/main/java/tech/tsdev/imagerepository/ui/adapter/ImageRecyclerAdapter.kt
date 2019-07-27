package tech.tsdev.imagerepository.ui.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.tsdev.imagerepository.base.viewmodel.baseAdaper.BaseAdapter
import tech.tsdev.imagerepository.data.UnsplashResponse
import tech.tsdev.imagerepository.ui.adapter.holder.ImageRecyclerHolder

class ImageRecyclerAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    BaseAdapter<UnsplashResponse> {
    override fun recyclerOnClickListener(onClick: (position: Int) -> Unit) {

    }

    private val imageList = mutableListOf<UnsplashResponse>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ImageRecyclerHolder(context, parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ImageRecyclerHolder).onBind(imageList[position])
    }

    override fun addItems(items: UnsplashResponse) {
        imageList
            .add(items)
    }

    override fun notifyedItemChange() {
        notifyDataSetChanged()
    }

    override fun getItems(position: Int): UnsplashResponse =
        imageList[position]

    override fun getItemCount(): Int =
        imageList.size

}