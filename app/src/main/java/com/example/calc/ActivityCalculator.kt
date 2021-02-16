package com.example.calc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.calc.calculator.Calculator
import kotlinx.android.synthetic.main.activity_calculator.*
import kotlinx.android.synthetic.main.activity_main.*

class ActivityCalculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        setListenersForAllButtons()
        val changeActivityColors:ChangeActivityColors = ChangeActivityColors()
        if(SwitchStatus.isSwitchButton())
            changeActivityColors.changeToLightTheme(activity_calculator)
        else changeActivityColors.changeToDarkTheme(activity_calculator)

    }

    @SuppressLint("SetTextI18n")
    fun setTextViewField(view: View) {
        view.setOnClickListener() {
            val buttonText = view as Button
            textView.text = textView.text.toString() + buttonText.text
        }
    }

    private fun clearTextField() {
        buttonСlear.setOnClickListener {
            textView.text = ""
        }
    }

    private fun clearLastChar() {
        buttonC.setOnClickListener {
            if (textView.text.isNotEmpty())
                textView.text = textView.text.substring(0, textView.text.length - 1)
        }
    }

    private fun getResult() {
        buttonResult.setOnClickListener {
            val calc: Calculator = Calculator()
            val numbers: Array<String> = arrayOf(textView.text.toString())
            textView.text = calc.count(numbers).toString()
        }
    }

    private fun setListenersForAllButtons() {
        setTextViewField(button1)
        setTextViewField(button2)
        setTextViewField(button3)
        setTextViewField(button4)
        setTextViewField(button5)
        setTextViewField(button6)
        setTextViewField(button7)
        setTextViewField(button8)
        setTextViewField(button9)
        setTextViewField(buttonMinus)
        setTextViewField(buttonZero)
        setTextViewField(buttonPlus)
        setTextViewField(buttonMultiply)
        setTextViewField(buttonDiv)
        setTextViewField(buttonPower)
        clearTextField()
        clearLastChar()
        getResult()

    }
}