package main;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    Random rd;

    public StringCalculatorTest() {
        this.rd = new Random();
    }

    @Test
    public void TestAdd() throws Exception {
        assertEquals(0, StringCalculator.Add(""));
        assertEquals(1, StringCalculator.Add("1"));
        assertEquals(2, StringCalculator.Add("2"));

        for (int i=0; i<10; i++) {
            int rand = rd.nextInt(1000);
            assertEquals(rand, StringCalculator.Add(String.valueOf(rand)));
        }

        Exception exception1 = assertThrows(Exception.class, () -> {StringCalculator.Add("-1");});
        assertTrue(exception1.getMessage().contains("negatives not allowed"));

        assertEquals(0, StringCalculator.Add("5000000"));

        assertEquals(3, StringCalculator.Add("1,2"));
        assertEquals(10, StringCalculator.Add("1,2,3,4"));

        assertEquals(10, StringCalculator.Add("1,2\n3\n4"));
    }
}