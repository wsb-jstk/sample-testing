package com.capgemini.sample.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void shouldReturn4_whenAdding2And2() {
        // given
        int firstNumber = 2;
        int secondNumber = 2;
        // when
        int result = calculator.add(firstNumber, secondNumber);
        // then
        assertEquals(4, result);
    }

    @Test
    void standardAssertions() {
        assertEquals(4, calculator.add(1, 3));
        assertEquals(8, calculator.multiply(2, 4));
        assertTrue(calculator.add(1, 3) < calculator.multiply(2, 3));
    }

}
