package com.example.calc;


import com.example.calc.calculator.Checks;

public class ErrorChecking {
    private final String inputString;

    public ErrorChecking(String inputString) {
        this.inputString = inputString;
    }

    boolean isIntroducedOperator() {
        for (int i = 0; i < inputString.length(); i++) {
            if (Checks.isOperation(inputString.charAt(i)))
                return true;
        }
        return false;
    }

    boolean isTwoCharInRow() {
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.length() > i+1)
                if (Checks.isOperation(inputString.charAt(i)) &&
                        Checks.isOperation(inputString.charAt(i + 1)))
                    return false;
        }
        return true;
    }

    boolean isLastCharNotOperator() {
        return !Checks.isOperation(inputString.charAt(inputString.length() - 1));
    }
}
