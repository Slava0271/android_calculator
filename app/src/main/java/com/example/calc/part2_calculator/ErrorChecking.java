package com.example.calc.part2_calculator;


import com.example.calc.calculator.Checks;

public class ErrorChecking {
    private final String inputString;

    public ErrorChecking(String inputString) {
        this.inputString = inputString;
    }

    public boolean isIntroducedOperator() {
        for (int i = 0; i < inputString.length(); i++) {
            if (Checks.isOperation(inputString.charAt(i)))
                return true;
        }
        return false;
    }

    public boolean isTwoCharInRow() {
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.length() > i + 1)
                if (Checks.isOperation(inputString.charAt(i)) &&
                        Checks.isOperation(inputString.charAt(i + 1)))
                    return false;
        }
        return true;
    }

    public boolean isLastCharNotOperator() {
        return !Checks.isOperation(inputString.charAt(inputString.length() - 1));
    }
}
