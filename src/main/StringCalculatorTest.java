package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {

    @Test
    public void TestAdd() {
        assertEquals(0, StringCalculator.Add(""));
    }
}