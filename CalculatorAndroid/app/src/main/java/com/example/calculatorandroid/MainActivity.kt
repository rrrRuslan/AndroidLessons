package com.example.calculatorandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.calculatorandroid.databinding.ActivityMainBinding

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }



    var isNewOp=true
    var dot=false
    fun buNumberEvent(view: View)
    {
        if(isNewOp)
        {
            binding.etShowNumber.setText("")
        }
        isNewOp=false
        val buSelect= view as Button
        var buClickValue:String=binding.etShowNumber.text.toString()
        when(buSelect.id)
        {
            binding.bu0.id->
            {
                buClickValue+="0"
            }
            binding.bu1.id->
            {
                buClickValue+="1"
            }
            binding.bu2.id->
            {
                buClickValue+="2"
            }
            binding.bu3.id->
            {
                buClickValue+="3"
            }
            binding.bu4.id->
            {
                buClickValue+="4"
            }
            binding.bu5.id->
            {
                buClickValue+="5"
            }
            binding.bu6.id->
            {
                buClickValue+="6"
            }
            binding.bu7.id->
            {
                buClickValue+="7"
            }
            binding.bu8.id->
            {
                buClickValue+="8"
            }
            binding.bu9.id->
            {
                buClickValue+="9"
            }
            binding.buDot.id->
            {
                if(dot==false)
                {
                    buClickValue += "."
                }
                dot=true
            }
            binding.buPlusMinus.id->
            {
                buClickValue="-" + buClickValue
            }
        }
        binding.etShowNumber.setText(buClickValue)
    }
    var op="X"
    var oldNumber=""

    fun buOpEvent(view: View)
    {
        val buSelect= view as Button
        when(buSelect.id)
        {
            binding.buMul.id->
            {
                op="X"
            }
            binding.buDiv.id->
            {
                op="÷"
            }
            binding.buSub.id->
            {
                op="-"
            }
            binding.buSum.id->
            {
                op="+"
            }
        }
        oldNumber=binding.etShowNumber.text.toString()
        isNewOp=true
        dot=false
    }

    fun buEqualEvent(view: View)
    {
        val newNumber=binding.etShowNumber.text.toString()
        var finalNumber:Double?=null
        when(op)
        {
            "X"->
            {
                finalNumber=oldNumber.toDouble() * newNumber.toDouble()
            }
            "÷"->
            {
                finalNumber=oldNumber.toDouble() / newNumber.toDouble()
            }
            "-"->
            {
                finalNumber=oldNumber.toDouble() - newNumber.toDouble()
            }
            "+"->
            {
                finalNumber=oldNumber.toDouble() + newNumber.toDouble()
            }
        }
        binding.etShowNumber.setText(finalNumber.toString())
        isNewOp=true
    }

    fun buPercentEvent(view: View)
    {
        val number=(binding.etShowNumber.text.toString().toDouble())/100
        binding.etShowNumber.setText(number.toString())
        isNewOp=true
    }

    fun buCleanEvent(view: View)
    {
        binding.etShowNumber.setText("")
        isNewOp=true
        dot=false
    }

}