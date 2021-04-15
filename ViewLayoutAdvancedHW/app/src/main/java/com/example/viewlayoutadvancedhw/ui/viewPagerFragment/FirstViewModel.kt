package com.example.viewlayoutadvancedhw.ui.viewPagerFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is first Fragment"
    }
    val text: LiveData<String> = _text
}