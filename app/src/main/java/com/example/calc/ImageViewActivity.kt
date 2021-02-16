package com.example.calc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calc.images.*
import kotlinx.android.synthetic.main.activity_calculator.*
import kotlinx.android.synthetic.main.activity_image_view.*
import kotlinx.android.synthetic.main.activity_main.*

class ImageViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)
        buttonListener()
        val changeActivityColors:ChangeActivityColors = ChangeActivityColors()
        if(SwitchStatus.isSwitchButton())
            changeActivityColors.changeToLightTheme(animals_images)
        else changeActivityColors.changeToDarkTheme(animals_images)

    }

    private fun buttonListener(){
        cat.setOnClickListener {
            startActivity(Intent(this,CatActivity::class.java))
        }
        goat.setOnClickListener {
            startActivity(Intent(this,GoatActivity::class.java))
        }
        horse.setOnClickListener {
            startActivity(Intent(this,HorseActivity::class.java))
        }
        mouse.setOnClickListener {
            startActivity(Intent(this,MouseActivity::class.java))
        }
        shark.setOnClickListener {
            startActivity(Intent(this,SharkActivity::class.java))
        }
    }


}