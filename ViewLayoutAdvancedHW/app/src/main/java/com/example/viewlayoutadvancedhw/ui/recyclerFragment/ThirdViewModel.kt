package com.example.viewlayoutadvancedhw.ui.recyclerFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ThirdViewModel : ViewModel() {

    val dataListView = MutableLiveData(
        mutableListOf(
            DataForItems(RecyclerViewAdapter.VIEW_TYPE_ONE, "1. Hi! I am View 1"),
            DataForItems(RecyclerViewAdapter.VIEW_TYPE_TWO, "2. Hi! I am View 2"),
            DataForItems(RecyclerViewAdapter.VIEW_TYPE_ONE, "3. Hi! I am View 3"),
            DataForItems(RecyclerViewAdapter.VIEW_TYPE_TWO, "4. Hi! I am View 4"),
            DataForItems(RecyclerViewAdapter.VIEW_TYPE_ONE, "5. Hi! I am View 5"),
            DataForItems(RecyclerViewAdapter.VIEW_TYPE_ONE, "6. Hi! I am View 6"),
            )
    )

    fun setData(dataForItems: DataForItems) {
        val list = ArrayList<DataForItems>()
        list.add(dataForItems)
        dataListView.value = list
    }

}