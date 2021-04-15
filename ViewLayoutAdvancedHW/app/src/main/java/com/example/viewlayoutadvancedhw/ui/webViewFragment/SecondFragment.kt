package com.example.viewlayoutadvancedhw.ui.webViewFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewlayoutadvancedhw.R

class SecondFragment : Fragment() {

    private lateinit var secondViewModel: SecondViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        secondViewModel =
                ViewModelProvider(this).get(SecondViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_second, container, false)

        val myWebView: WebView = root.findViewById(R.id.webview)

        myWebView.loadUrl("https://developer.android.com/guide/webapps/webview#add-webview-layout")

        return root
    }
}