package com.example.mentortask

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var textView: TextView
    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var buttonColor: Button


    lateinit var mCallback: TextSendListener

    //defining Interface
    interface TextSendListener {
        fun sendText(text: String)
    }

    fun setOnTextSendListener(callback: TextSendListener) {
        this.mCallback = callback
    }

    fun yourMethodofSendingText() {
        //here you can get the text from the edit text or can use this method according to your need
        mCallback.sendText(editText.text.toString())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_first, container, false)

        textView = view.findViewById(R.id.fr1_text)
        editText = view.findViewById(R.id.fr1_input)
        button = view.findViewById(R.id.fr1_button)
        buttonColor = view.findViewById(R.id.colorButton)

        buttonColor.setOnClickListener {
            val fragment = fragmentManager?.findFragmentById(R.id.container_b)
            fragment?.view?.setBackgroundColor(Color.RED)
        }
        button.setOnClickListener {
//            viewModel.setText(editText.text.toString())
/*
            val bundle = Bundle()
            bundle.putString("key", editText.text.toString())
            var secondFragment = SecondFragment()

            secondFragment.arguments = bundle
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container_b, secondFragment)?.commit()*/

            yourMethodofSendingText()

        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }






    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}