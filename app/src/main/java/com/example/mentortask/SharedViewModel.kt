package com.example.mentortask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class SharedViewModel : ViewModel() {

    private val text = MutableLiveData<String>()

    fun setText(input: String) {
        text.value = input
    }

    fun getText(): LiveData<String> {
        return text
    }

}