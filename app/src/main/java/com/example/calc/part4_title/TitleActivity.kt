package com.example.calc.part4_title

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calc.R

class TitleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_title)
        supportActionBar?.hide()
    }
}