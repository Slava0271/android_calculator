package com.example.calc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_image_view.*
import kotlinx.android.synthetic.main.activity_main.*

class ImageViewActivity : AppCompatActivity() {
    var count = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)
        drawFirstImage()
        buttonListeners()

        val changeActivityColors: ChangeActivityColors = ChangeActivityColors()
        if (SwitchStatus.isSwitchButton())
            changeActivityColors.changeToLightTheme(animals_images)
        else changeActivityColors.changeToDarkTheme(animals_images)

    }

    private fun drawFirstImage() {
        imageView.setImageResource(R.drawable.cat)
    }

    private fun buttonListeners() {
        buttonNext.setOnClickListener {
            if (count < 5)
                count++
            setImages()
        }

        buttonPrev.setOnClickListener {
            if(count>0)
                count--
            setImages()
        }
    }

    private fun setImages(){
        when (count) {
            0 -> imageView.setImageResource(R.drawable.cat)
            1 -> imageView.setImageResource(R.drawable.shark)
            2 -> imageView.setImageResource(R.drawable.mouse)
            3 -> imageView.setImageResource(R.drawable.goat)
            4 -> imageView.setImageResource(R.drawable.horse)
        }
    }


}