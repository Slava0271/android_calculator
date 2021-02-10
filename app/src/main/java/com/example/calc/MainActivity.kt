package com.example.calc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun toCalculator (view:View) {
        val changeActivity = Intent(this,Calculator::class.java)
        startActivity(changeActivity)
    }
}