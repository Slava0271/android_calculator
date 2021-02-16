package com.example.calc.images

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calc.R
import kotlinx.android.synthetic.main.activity_goat.*

class GoatActivity : AppCompatActivity(),DrawImage {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goat)
        drawImage()
    }

    override fun drawImage() {
        imageGoat.setImageResource(R.drawable.goat)
    }
}