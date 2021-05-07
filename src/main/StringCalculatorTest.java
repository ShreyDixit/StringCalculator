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
    public void TestAddBasic() throws Exception {
        assertEquals(0, StringCalculator.Add(""));
        assertEquals(1, StringCalculator.Add("1"));
        assertEquals(2, StringCalculator.Add("2"));
        assertEquals(0, StringCalculator.Add("5000000"));
    }

    @Test
    public void TestAddNegativeException() throws Exception {
        Exception exception1 = assertThrows(Exception.class, () -> {StringCalculator.Add("-1");});
        assertTrue(exception1.getMessage().contains("Negative Numbers Found : -1"));

        Exception exception2 = assertThrows(Exception.class, () -> {StringCalculator.Add("-1,-5\n-10");});
        assertTrue(exception2.getMessage().contains("Negative Numbers Found : -1,-5,-10"));
    }

    @Test
    public void TestAddMultipleNumbers() throws Exception {
        assertEquals(3, StringCalculator.Add("1,2"));
        assertEquals(10, StringCalculator.Add("1,2,3,4"));
        assertEquals(10, StringCalculator.Add("1,2\n3\n4"));
    }

    @Test
    public void TestAddCustomDelimiter() throws Exception {
        assertEquals(3, StringCalculator.Add("//;\n1;2"));

        assertEquals(3, StringCalculator.Add("//[***]\n1***2"));

        assertEquals(15, StringCalculator.Add("//[*][;]\n1*2;8*4"));
        assertEquals(15, StringCalculator.Add("//[**][;+]\n1**2;+8**4"));
    }

    @Test
    public void TestAddCalledCount() throws Exception {

        int runCount = StringCalculator.GetCalledCount();
        int randNum = rd.nextInt(5000);

        for(int i=0; i<randNum; i++)
            StringCalculator.Add("");

        assertEquals(runCount + randNum, StringCalculator.GetCalledCount());
    }
}