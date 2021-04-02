package com.example.mentortask

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var textView: TextView
    private lateinit var editText: EditText
    private lateinit var button: Button

    lateinit var viewModel: SharedViewModel

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
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        textView = view.findViewById(R.id.fr2_text)
        editText = view.findViewById(R.id.fr2_input)
        button = view.findViewById(R.id.fr2_button)

        textView.text = "Second fragment"


        viewModel.getText().observe(this, {
            updateText(it)
        } )

        button.setOnClickListener {
//            val string = viewModel.getText().value
//            Log.i("DATA_GOT_FROM_VIEWMODEL", "onCreateView: $string")
//            string?.let { updateText(it) }
            Log.i("SENDING_TEXT_TO_ViewMOD", "onCreateView: ${editText.text.toString()}")
            viewModel.setText(editText.text.toString())

        }

        return view
    }

    fun updateText(text: String) {
        editText.setText(text)
    }


}