package com.example.calc.part3_images

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.calc.R
import kotlinx.android.synthetic.main.activity_change_color.*
import com.example.calc.part3_images.MyAppGlideModule


class ChangeColorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_color)

        val uri:Uri = Uri.parse("http://upload.wikimedia.org/wikipedia/commons/e/e8/Svg_example3.svg")
        Glide.with(this).load(uri).into(changeImage)
    }
}