package com.kata.stringcalculator;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        // Check for custom delimiter in string
        String delimiter = ",|\n";

        if (numbers.startsWith("//")) {
            // The delimiter is the character between // and the first \n
            delimiter = String.valueOf(numbers.charAt(2));
            // Strip leaving just the numbers
            numbers = numbers.substring(numbers.indexOf("\n"));
		}

        String[] parts = numbers.split(delimiter);
        int sum = 0;
        for (String part : parts) {
            sum += Integer.parseInt(part.trim());
        }

        return sum;
    }
}
