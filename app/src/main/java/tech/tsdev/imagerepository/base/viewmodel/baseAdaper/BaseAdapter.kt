package tech.tsdev.imagerepository.base.viewmodel.baseAdaper

interface BaseAdapter<T> {
    fun addItems(items: T)

    fun notifyedItemChange()

    fun getItems(position: Int): T

    fun getItemCount(): Int
}