package com.example.calc.part3_images

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calc.R
import kotlinx.android.synthetic.main.activity_change_image_color.*
import kotlinx.android.synthetic.main.activity_image_view.imageViewChangeColor

class ChangeImageColorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_image_color)
        drawFirstImage()
        red.setOnClickListener {
            val color: Int = Color.parseColor("#AE6118") //The color u want
            imageViewChangeColor.setColorFilter(color)
        }
    }

    private fun drawFirstImage() {
        imageViewChangeColor.setImageResource(R.drawable.cat)
    }
}