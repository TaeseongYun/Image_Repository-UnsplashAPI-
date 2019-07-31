package tech.tsdev.imagerepository.base.viewmodel.baseAdaper

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class AndroidRecyclerView(private val containerView: View) :
        RecyclerView.ViewHolder(containerView)