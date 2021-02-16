package com.example.calc.images

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calc.R
import kotlinx.android.synthetic.main.activity_mouse.*

class MouseActivity : AppCompatActivity(),DrawImage {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mouse)
        drawImage()
    }

    override fun drawImage() {
        imageMouse.setImageResource(R.drawable.mouse)
    }
}