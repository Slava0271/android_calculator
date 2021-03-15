package com.example.calc.part4_title

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calc.R
import kotlinx.android.synthetic.main.activity_title.*

class TitleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_title)
        supportActionBar?.hide()
        setAvatarPhoto()
    }
    private fun setAvatarPhoto(){
        imageViewAvatar.setImageResource(R.drawable.ic_launcher_foreground)
    }
}