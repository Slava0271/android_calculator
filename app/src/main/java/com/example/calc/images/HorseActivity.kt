package com.example.calc.images

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calc.R
import kotlinx.android.synthetic.main.activity_horse.*

class HorseActivity : AppCompatActivity(),DrawImage {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horse)
        drawImage()
    }

    override fun drawImage() {
        imageHorse.setImageResource(R.drawable.horse)
    }
}