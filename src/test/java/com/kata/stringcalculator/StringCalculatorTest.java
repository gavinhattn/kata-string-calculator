package com.kata.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("Empty string returns 0")
    void emptyStringReturnsZero() {
        assertThat(calculator.add("")).isZero();
    }

    @Test
    @DisplayName("Single number returns that number")
    void singleNumberReturnsItself() {
        assertThat(calculator.add("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("Two comma-separated numbers return their sum")
    void twoNumbersReturnSum() {
        assertThat(calculator.add("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("Multiple comma-separated numbers return their sum")
    void multipleNumbersReturnSum() {
        assertThat(calculator.add("1,2,3,4,5")).isEqualTo(15);
    }

    @Test
    @DisplayName("Newline can be used as a delimiter")
    void newlineAsDelimiter() {
        assertThat(calculator.add("1\n2,3")).isEqualTo(6);
    }

    @Test
    @DisplayName("Custom delimiter declared in string is used for splitting")
    void customDelimiter() {
        assertThat(calculator.add("//;\n1;2")).isEqualTo(3);
    }

}
