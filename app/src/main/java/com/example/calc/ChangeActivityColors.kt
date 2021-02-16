package com.example.calc

import android.graphics.Color
import android.widget.Switch
import androidx.constraintlayout.widget.ConstraintLayout

class ChangeActivityColors {
    fun listenSwitchButton(switch: Switch, constraintLayoutMain: ConstraintLayout) {
        switch.setOnCheckedChangeListener() { _, isChecked ->
            if (isChecked) {
                changeToLightTheme(constraintLayoutMain)
                SwitchStatus.setIsSwitchButton(true)
            } else {
                changeToDarkTheme(constraintLayoutMain)
                SwitchStatus.setIsSwitchButton(false)
            }
        }
    }

     fun changeToDarkTheme(constraintLayoutMain: ConstraintLayout) {
        constraintLayoutMain.setBackgroundColor(Color.rgb(21,21,21))
    }

    fun changeToLightTheme(constraintLayoutMain: ConstraintLayout) {
        constraintLayoutMain.setBackgroundColor(Color.rgb(252 ,243,214))
    }
}