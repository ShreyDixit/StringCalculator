package main;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {
    Random rd;

    public StringCalculatorTest() {
        this.rd = new Random();
    }

    @Test
    public void TestAdd() {
        assertEquals(0, StringCalculator.Add(""));
        assertEquals(1, StringCalculator.Add("1"));
        assertEquals(2, StringCalculator.Add("2"));
        for (int i=0; i<10; i++) {
            int rand = rd.nextInt();
            assertEquals(rand, StringCalculator.Add(String.valueOf(rand)));
        }
    }
}