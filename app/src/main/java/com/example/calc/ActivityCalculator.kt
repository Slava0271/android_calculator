package com.example.calc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.calc.calculator.Calculator
import kotlinx.android.synthetic.main.activity_calculator.*

class ActivityCalculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        addListenersForAllButton()
        val changeActivityColors: ChangeActivityColors = ChangeActivityColors()
        if (SwitchStatus.isSwitchButton())
            changeActivityColors.changeToLightTheme(activity_calculator)
        else changeActivityColors.changeToDarkTheme(activity_calculator)

    }

    @SuppressLint("SetTextI18n")
    fun setTextViewField(view: View) {
        val buttonText = view as Button
        textView.text = textView.text.toString() + buttonText.text
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

    private fun countResultAndPrintToDisplay() {
        buttonResult.setOnClickListener {
            val calc: Calculator = Calculator()
            val numbers: Array<String> = arrayOf(textView.text.toString())
            textView.text = calc.count(numbers).toString()
        }
    }

    fun addListenersForAllButton() {
        val listOfButtons: ArrayList<View> = arrayListOf<View>(
                button1,
                button2,
                button3,
                button4,
                button5,
                button6,
                button7,
                button8,
                button9,
                buttonMinus,
                buttonZero,
                buttonPlus,
                buttonMultiply,
                buttonDiv,
                buttonPower
        )

        clearTextField()
        clearLastChar()
        countResultAndPrintToDisplay()
        listOfButtons.forEach { v ->
            v.setOnClickListener(setTextListeners())
        }
    }


    private fun setTextListeners(): View.OnClickListener {
        return View.OnClickListener { v ->
            when (v) {
                button1 -> setTextViewField(button1)
                button2 -> setTextViewField(button2)
                button3 -> setTextViewField(button3)
                button4 -> setTextViewField(button4)
                button5 -> setTextViewField(button5)
                button6 -> setTextViewField(button6)
                button7 -> setTextViewField(button7)
                button8 -> setTextViewField(button8)
                button9 -> setTextViewField(button9)
                buttonMinus -> setTextViewField(buttonMinus)
                buttonZero -> setTextViewField(buttonZero)
                buttonPlus -> setTextViewField(buttonPlus)
                buttonMultiply -> setTextViewField(buttonMultiply)
                buttonDiv -> setTextViewField(buttonDiv)
                buttonPower -> setTextViewField(buttonPower)
            }
        }
    }

}