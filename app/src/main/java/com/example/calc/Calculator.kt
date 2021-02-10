package com.example.calc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_calculator.*
import com.example.calc.calculator.Calculator


class Calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        // textView.text=""
    }

    @SuppressLint("SetTextI18n")
    fun onClickAction(view: View) {
        val string: String = textView.text.toString()
        val t = view as Button
        textView.text = string + t.text
    }

    fun count(view: View) {
        val calculator: Calculator = Calculator()
        val numbers: Array<String> = arrayOf()
        numbers[0] = textView.text.toString()
        val result: Double = calculator.count(numbers)
        textView.text=result.toString()
    }

}