package com.example.viewlayoutadvancedhw.ui.viewPagerFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.viewlayoutadvancedhw.R

class FirstFragment : Fragment() {

    private lateinit var firstViewModel: FirstViewModel
    private lateinit var viewPager: ViewPager2
    private val PAGES = 3


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        firstViewModel =
            ViewModelProvider(this).get(FirstViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_first, container, false)

        // Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = root.findViewById(R.id.view_pager)

        // The pager adapter, which provides the pages to the view pager widget.
        val pagerAdapter = ScreenSlidePagerAdapter(this)
        viewPager.adapter = pagerAdapter

        return root
    }


    private inner class ScreenSlidePagerAdapter(fa: Fragment) : FragmentStateAdapter(fa) {

        override fun getItemCount(): Int = PAGES
        
        var int = 0;

        override fun createFragment(position: Int): Fragment =
            ScreenSlidePageFragment("This is $int fragment of ViewPager2").also { int++ }
    }

}