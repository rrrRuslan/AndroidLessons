package com.example.viewlayoutadvancedhw.ui.recyclerFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.map
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewlayoutadvancedhw.R

class ThirdFragment : Fragment() {

    private lateinit var thirdViewModel: ThirdViewModel
    private lateinit var recyclerView: RecyclerView
    private var dataList = ArrayList<DataForItems>()


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_third, container, false)
        thirdViewModel = ViewModelProvider(this).get(ThirdViewModel::class.java)



        thirdViewModel.dataListView.observe(viewLifecycleOwner,{ data ->
            data.forEach {
                dataList.add(it)
            }
        })
        Log.i("LIST OF ITEMS", "onCreateView: $dataList")
        val adapter = RecyclerViewAdapter(root.context, dataList)
        recyclerView = root.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(root.context)
        recyclerView.adapter = adapter

        return root
    }
}