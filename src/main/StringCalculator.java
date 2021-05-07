package main;

import java.util.LinkedList;

public class StringCalculator {
    public static int Add(String numbers) throws Exception {
        numbers = processNumbers(numbers);
        String[] parts = numbers.split(",");
        int sum = 0;
        for (String part:parts){
            sum += processPart(part);
        }

        return sum;
    }
    
    private static String processNumbers(String numbers) {
        LinkedList<String> delims = new LinkedList<String>();
        if (numbers.length() > 3) {
            if (numbers.substring(0, 2).equals("//")) {
//                if (numbers.charAt(2)=='[') {
//
//                }
                delims.add(numbers.substring(2, 3));
                numbers = numbers.substring(numbers.indexOf("\n") + 1);
            }
        }

        if (delims.isEmpty())
            delims.add("\n");
        for (String delim: delims)
            numbers = numbers.replaceAll(delim, ",");
        
        return numbers;
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
