package com.example.calc.part3_images

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calc.R
import com.example.calc.part8_change_color.ChangeActivityColors
import com.example.calc.part8_change_color.SwitchStatus
import kotlinx.android.synthetic.main.activity_image_view.*

class ImageViewActivity : AppCompatActivity() {
    var count = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)
        supportActionBar?.hide()
        drawFirstImage()
        buttonListeners()

        val changeActivityColors: ChangeActivityColors = ChangeActivityColors()
        if (SwitchStatus.isSwitchButton())
            changeActivityColors.changeToLightTheme(animals_images)
        else changeActivityColors.changeToDarkTheme(animals_images)

    }

    private fun drawFirstImage() {
        imageViewChangeColor.setImageResource(R.drawable.cat)
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
            0 -> imageViewChangeColor.setImageResource(R.drawable.cat)
            1 -> imageViewChangeColor.setImageResource(R.drawable.shark)
            2 -> imageViewChangeColor.setImageResource(R.drawable.mouse)
            3 -> imageViewChangeColor.setImageResource(R.drawable.goat)
            4 -> imageViewChangeColor.setImageResource(R.drawable.horse)
        }
    }


}