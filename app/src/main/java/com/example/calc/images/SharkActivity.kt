package com.example.calc.images

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calc.R
import kotlinx.android.synthetic.main.activity_shark.*

class SharkActivity : AppCompatActivity(),DrawImage {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shark)
        drawImage()
    }

    override fun drawImage() {
        imageShark.setImageResource(R.drawable.shark)
    }
}