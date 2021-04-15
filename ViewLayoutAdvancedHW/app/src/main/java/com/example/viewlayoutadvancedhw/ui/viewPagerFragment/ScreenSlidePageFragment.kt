package com.example.viewlayoutadvancedhw.ui.viewPagerFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.viewlayoutadvancedhw.R


class ScreenSlidePageFragment(var name:String) : Fragment() {

    private lateinit var text:TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val root =inflater.inflate(R.layout.fragment_screen_slide_page, container, false)

        text = root.findViewById(R.id.vp_frag_text)
        text.text = name

        return root
    }
}