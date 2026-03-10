package com.kata.stringcalculator;

import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        // Check for custom delimiter in string
        String delimiter = ",|\n";

        if (numbers.startsWith("//")) {
            String header = numbers.substring(2, numbers.indexOf("\n"));
            if (header.startsWith("[") && header.endsWith("]")) {
                StringBuilder regexBuilder = new StringBuilder();
                int i = 0;
                while (i < header.length()) {
                    if (header.charAt(i) == '[') {
                        int closing = header.indexOf(']', i);
                        // Extract the delimiter between the brackets
                        String part = header.substring(i + 1, closing);
                        if (!regexBuilder.isEmpty()) {
                            regexBuilder.append("|");
                        }
                        regexBuilder.append(Pattern.quote(part));
                        i = closing + 1;
                    } else {
                        i++;
                    }
                }
                delimiter = regexBuilder.toString();
            } else {
                delimiter = Pattern.quote(header);
            }
            numbers = numbers.substring(numbers.indexOf("\n") + 1);
        }

        String[] parts = numbers.split(delimiter);
        int sum = 0;
        StringBuilder negatives = new StringBuilder();

        for (String part : parts) {
            int number = Integer.parseInt(part.trim());

            // Collect all negative numbers before throwing - gives the caller the full list
            if (number < 0) {
                if (!negatives.isEmpty()) {
                    negatives.append(",");
                }
                negatives.append(number);
            }

            // Ignore numbers greater than 1000
            if (number <= 1000) {
                sum += number;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }

        return sum;
    }
}
