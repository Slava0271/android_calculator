package com.example.calc

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calculator.setOnClickListener {
            toCalculator(calculator)
        }
        images.setOnClickListener {
            toViewActivity(images)
        }
        val changeActivityColors:ChangeActivityColors = ChangeActivityColors()
        changeActivityColors.listenSwitchButton(switchChangeColor,main_activity)

    }
    private fun toCalculator (view:View) {
        startActivity(Intent(this,ActivityCalculator::class.java))
    }
    private fun toViewActivity(view:View){
        startActivity(Intent(this,ImageViewActivity::class.java))
    }
}