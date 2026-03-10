package com.kata.stringcalculator;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        // Splitting by comma handles any number of inputs, not just two
        String[] parts = numbers.split(",|\n");
        int sum = 0;
        for (String part : parts) {
            sum += Integer.parseInt(part);
        }

        return sum;
    }
}
