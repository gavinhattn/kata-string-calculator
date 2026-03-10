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

        // Check for negatives - collect all of them before throwing
        String negatives = "";
        for (String part : parts) {
            if (Integer.parseInt(part.trim()) < 0) {
                negatives += part.trim() + ",";
            }
        }
        if (!negatives.isEmpty()) {
            // Remove trailing comma before throwing
            throw new IllegalArgumentException("Negatives not allowed: " + negatives.replaceAll(",$", ""));
        }

        for (String part : parts) {
            int number = Integer.parseInt(part.trim());

            // Ignore numbers greater than 1000
            if (number <= 1000) {
                sum += number;
            }
        }

        return sum;
    }
}
