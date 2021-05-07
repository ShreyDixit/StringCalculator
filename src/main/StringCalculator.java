package main;

public class StringCalculator {
    public static int Add(String numbers) throws Exception {
        if (numbers.equals(""))
            return 0;

        int num = Integer.parseInt(numbers);
        if (num<0)
            throw new Exception("negatives not allowed");
        return num;
    }
}
