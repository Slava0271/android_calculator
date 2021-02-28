package com.example.calc.part8_change_color;

public class SwitchStatus {
     private static boolean isSwitchButton = false;

     public static boolean isSwitchButton() {
         return isSwitchButton;
     }

     public static void setIsSwitchButton(boolean isSwitchButton) {
         SwitchStatus.isSwitchButton = isSwitchButton;
     }
 }
