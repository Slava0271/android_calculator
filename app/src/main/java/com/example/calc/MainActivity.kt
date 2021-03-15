package com.example.calc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.calc.part2_calculator.ActivityCalculator
import com.example.calc.part3_images.ChangeColorActivity
import com.example.calc.part3_images.ImageViewActivity
import com.example.calc.part4_title.TitleActivity
import com.example.calc.part8_change_color.ChangeActivityColors
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeTheme()

        calculator.setOnClickListener {
            toCalculator(calculator)
        }
        images.setOnClickListener {
            toViewActivity(images)
        }
        titleActivity.setOnClickListener {
            toTitles()
        }
        changeImageColorButton.setOnClickListener {
            toChangeImageColor()
        }

    }

    private fun changeTheme(){
        val changeActivityColors: ChangeActivityColors = ChangeActivityColors()
        changeActivityColors.listenSwitchButton(switchChangeColor,main_activity)

    }
    private fun toCalculator (view:View) {
        startActivity(Intent(this, ActivityCalculator::class.java))
    }
    private fun toViewActivity(view:View){
        startActivity(Intent(this, ImageViewActivity::class.java))
    }
    private fun toTitles (){
        startActivity(Intent(this, TitleActivity::class.java))
    }
    private fun toChangeImageColor(){
        startActivity(Intent(this, ChangeColorActivity::class.java))
    }

}