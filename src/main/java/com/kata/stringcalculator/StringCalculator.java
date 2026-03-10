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
