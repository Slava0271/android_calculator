package com.example.calc;

 class SwitchStatus {
     private static boolean isSwitchButton = false;

     public static boolean isSwitchButton() {
         return isSwitchButton;
     }

     public static void setIsSwitchButton(boolean isSwitchButton) {
         SwitchStatus.isSwitchButton = isSwitchButton;
     }
 }
