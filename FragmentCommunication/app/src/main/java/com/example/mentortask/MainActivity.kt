package com.example.mentortask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(), FirstFragment.TextSendListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.beginTransaction()
            .add(R.id.container_a, FirstFragment())
            .add(R.id.container_b, SecondFragment())
            .commit()

    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        if (fragment is FirstFragment)
            fragment.setOnTextSendListener(this)
    }

    override fun sendText(text: String) {
        val frag = supportFragmentManager.findFragmentById(R.id.container_b) as SecondFragment
        frag.updateText(text)
    }


}