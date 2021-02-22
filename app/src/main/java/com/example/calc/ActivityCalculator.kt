package com.example.calc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.calc.calculator.Calculator
import kotlinx.android.synthetic.main.activity_calculator.*

class ActivityCalculator : AppCompatActivity() {
    private var errorMessage: String = "Ошибка"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        supportActionBar?.hide()
        addListenersForAllButton()
        addTextListener()
        val changeActivityColors: ChangeActivityColors = ChangeActivityColors()
        if (SwitchStatus.isSwitchButton())
            changeActivityColors.changeToLightTheme(activity_calculator)
        else changeActivityColors.changeToDarkTheme(activity_calculator)

    }

    @SuppressLint("SetTextI18n")
    fun updateTextView(button: Button, view: TextView) {
        view.text = view.text.toString() + button.text
    }

    private fun initListenerForClearTextField() {
        buttonСlear.setOnClickListener {
            textView.text = ""
        }
    }

    private fun addListenerForDeleteLastChar() {
        buttonC.setOnClickListener {
            if (textView.text.isNotEmpty())
                textView.text = textView.text.substring(0, textView.text.length - 1)
        }
    }

//    private fun addListenerToPrintResultOnTextField() {
//        val errorMessage: String = "Ошибка"
//        buttonResult.setOnClickListener {
//            countResult()
//        }
//    }

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
            v.setOnClickListener(addButtonListener())
        }

        initListenerForClearTextField()
        addListenerForDeleteLastChar()
        // addListenerToPrintResultOnTextField()

    }


    @SuppressLint("ShowToast", "ResourceType")
    private fun addButtonListener(): View.OnClickListener {
        return View.OnClickListener { v ->
            updateTextView(v as Button, textView)
        }
    }

    private fun addTextListener() {
        textView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                val inputText: String = textView.text.toString()
//                buttonResult.isClickable = inputText.isNotEmpty()
                countResult()
            }
        })

    }

    private fun countResult() {
        val calc: Calculator = Calculator()
        val errorChecking: ErrorChecking = ErrorChecking(textView.text.toString())
        val numbers: Array<String> = arrayOf(textView.text.toString())
        if (errorChecking.isIntroducedOperator && errorChecking.isTwoCharInRow
                && errorChecking.isLastCharNotOperator)
            textViewResult.text = calc.count(numbers).toString()
        else textViewResult.text = errorMessage
    }

}

