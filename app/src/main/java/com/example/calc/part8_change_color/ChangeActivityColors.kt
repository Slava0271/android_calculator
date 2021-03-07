package com.example.calc.part8_change_color

import android.app.AppComponentFactory
import android.graphics.Color
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout

class ChangeActivityColors {
    fun listenSwitchButton(switch: Switch, constraintLayoutMain: ConstraintLayout) {
        switch.setOnCheckedChangeListener() { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
}