package main;

public class StringCalculator {
    public static int Add(String numbers) throws Exception {
        if (numbers.equals(""))
            return 0;

        numbers = numbers.replaceAll("\n", ",");
        String[] parts = numbers.split(",");
        int sum = 0;
        for (String part:parts){
            sum += processPart(part);
        }

        return sum;
    }

    private static int processPart(String number) throws Exception {
        if (number.equals(""))
            return 0;

        int num = Integer.parseInt(number);
        if (num<0)
            throw new Exception("negatives not allowed");
        if (num>1000)
            return 0;
        return num;
    }
}
