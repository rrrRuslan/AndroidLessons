package com.example.mentortask

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get

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

    lateinit var viewModel: SharedViewModel


    lateinit var mCallback: TextSendListener

    //defining Interface
    interface TextSendListener {
        fun sendText(text: String)
    }

    fun setOnTextSendListener(callback: TextSendListener) {
        this.mCallback = callback
    }

    fun myMethodOfSendingText() {
        mCallback.sendText(editText.text.toString())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)
        viewModel = activity?.run {
            ViewModelProvider(this).get(SharedViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_first, container, false)



        textView = view.findViewById(R.id.fr1_text)
        editText = view.findViewById(R.id.fr1_input)
        button = view.findViewById(R.id.fr1_button)
        buttonColor = view.findViewById(R.id.colorButton)

        textView.text = "First fragment"

        viewModel.getText().observe(this, {
            updateText(it)
        } )

        buttonColor.setOnClickListener {
            val fragment = fragmentManager?.findFragmentById(R.id.container_b)
            fragment?.view?.setBackgroundColor(Color.RED)
        }
        button.setOnClickListener {

//            myMethodOfSendingText()
            Log.i("SENDING_TEXT_TO_ViewMOD", "onCreateView: ${editText.text.toString()}")
            viewModel.setText(editText.text.toString())
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    fun updateText(text: String) {
        editText.setText(text)
    }

}