package com.example.viewlayoutadvancedhw.ui.webViewFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is second Fragment"
    }
    val text: LiveData<String> = _text
}