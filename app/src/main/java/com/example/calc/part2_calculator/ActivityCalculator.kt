package com.example.calc.part2_calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.example.calc.calculator.Calculator
import kotlinx.android.synthetic.main.activity_calculator.*
import com.example.calc.R
import com.example.calc.part8_change_color.ChangeActivityColors
import com.example.calc.part8_change_color.SwitchStatus

class ActivityCalculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        supportActionBar?.hide()
        addListenersForAllButton()
        addTextListener()
        val changeActivityColors: ChangeActivityColors = ChangeActivityColors()
        if (SwitchStatus.isSwitchButton())
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

    }

    /**
     * The method that adds the pressed
     * button to the entered function
     *
     * return - updated function
     */
    private fun updateTextView(button: Button, view: TextView): String {
        return view.text.toString() + getButtonText(button)
    }

    /**
     * A method that returns the desired character
     * depending on the button pressed
     */
    private fun getButtonText(button: Button): String {
        when (button.id) {
            R.id.button1 -> return "1"
            R.id.button2 -> return "2"
            R.id.button3 -> return "3"
            R.id.button4 -> return "4"
            R.id.button5 -> return "5"
            R.id.button6 -> return "6"
            R.id.button7 -> return "7"
            R.id.button8 -> return "8"
            R.id.button9 -> return "9"
            R.id.buttonZero -> return "0"
            R.id.buttonPlus -> return "+"
            R.id.buttonMinus -> return "-"
            R.id.buttonMultiply -> return "*"
            R.id.buttonDiv -> return "/"
            R.id.buttonPower -> return "^"
        }

        throw NullPointerException()
    }

    /**
     * Method that clears the text field
     * when the button clear is pressed
     */
    private fun initListenerForClearTextField() {
        buttonСlear.setOnClickListener {
            inputFunction.text = ""
        }
    }

    /**
     * Method that removes the last character from
     * the function when the button С is pressed
     */
    private fun addListenerForDeleteLastChar() {
        buttonC.setOnClickListener {
            if (inputFunction.text.isNotEmpty())
                inputFunction.text = inputFunction.text.substring(0, inputFunction.text.length - 1)
        }
    }

    /**
     * Method in which listeners are added for all buttons
     */
    private fun addListenersForAllButton() {
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
        listOfButtons.forEach { v ->
            v.setOnClickListener() {
                inputFunction.text = updateTextView(v as Button, inputFunction)
            }
        }

        initListenerForClearTextField()
        addListenerForDeleteLastChar()

    }

    /**
     * The method in which the changedTextListener is hung on the input field,
     * where when it changes, the method calculateResult() is called
     */
    private fun addTextListener() {
        inputFunction.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val result: Double? = calculateResult()
                if (result != null)
                    textViewResult.text = result.toString()
            }
        })

    }

    /**
     *  The method in which the result of the entered function
     *  is calculated and the value is returned, if the result
     *  was not counted, an error message is displayed and null is returned
     */
    private fun calculateResult(): Double? {
        val calc: Calculator = Calculator()
        val errorChecking: ErrorChecking = ErrorChecking(inputFunction.text.toString())
        val numbers: Array<String> = arrayOf(inputFunction.text.toString())
        return if (errorChecking.isIntroducedOperator && errorChecking.isTwoCharInRow
                && errorChecking.isLastCharNotOperator)
            calc.count(numbers)
        else {
            textViewResult.text = getString(R.string.error_message)
            null
        }
    }

}

