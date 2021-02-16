package com.example.calc.images

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.calc.R
import kotlinx.android.synthetic.main.activity_cat.*

class CatActivity : AppCompatActivity(), DrawImage {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat)
        drawImage()
    }

    override fun drawImage() {
        imageCat.setImageResource(R.drawable.cat)
    }

}