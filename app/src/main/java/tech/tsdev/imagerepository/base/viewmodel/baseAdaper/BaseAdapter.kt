package tech.tsdev.imagerepository.base.viewmodel.baseAdaper

interface BaseAdapter<in T> {
    fun addItems(items: T)
}