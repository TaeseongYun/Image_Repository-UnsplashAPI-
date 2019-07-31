package tech.tsdev.imagerepository.base.viewmodel.baseAdaper

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BaseViewHolder<in ITEM : Any>(
    context: Context?,
    layoutInflater: Int,
    parent: ViewGroup
) : AndroidRecyclerView(
    LayoutInflater.from(context).inflate(
        layoutInflater,
        parent,
        false
    )
) {
    abstract fun onBindViewHolder(item: ITEM?)
}