package main;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static int callCount = 0;

    public static int Add(String numbers) throws Exception {
        callCount++;

        numbers = processNumbers(numbers);
        String[] parts = numbers.split(",");
        LinkedList<String> negNums = new LinkedList<String>();

        int sum = 0;

        for (String part : parts) {
            try {
                sum += processPart(part);
            } catch (IllegalArgumentException i) {
                negNums.add(i.getMessage());
            }
        }

        if (!negNums.isEmpty())
            throw new Exception("Negative Numbers Found : " + String.join(",", negNums));

        return sum;
    }

    private static String processNumbers(String numbers) {
        LinkedList<String> delims = new LinkedList<String>();

        if (checkDelimiters(numbers)) {
            getDelimiters(numbers, delims);
            numbers = numbers.substring(numbers.indexOf("\n") + 1);
        }

        delims.add("\n");
        for (String delim : delims)
            numbers = numbers.replaceAll(Pattern.quote(delim), ",");

        return numbers;
    }

    private static boolean checkDelimiters(String numbers) {
        return numbers.length() > 3 && numbers.substring(0, 2).equals("//");
    }

    private static void getDelimiters(String numbers, LinkedList<String> delims) {
        if (numbers.charAt(2) == '[') {
            Pattern regex = Pattern.compile("\\[(.*?)\\]");
            Matcher regexMatcher = regex.matcher(numbers);

            while (regexMatcher.find()) {//Finds Matching Pattern in String
                delims.add(regexMatcher.group(1));//Fetching Group from String
            }
        }

        delims.add(numbers.substring(2, 3));
    }

    private static int processPart(String number) throws IllegalArgumentException {
        if (number.equals(""))
            return 0;

        int num = Integer.parseInt(number);
        if (num < 0)
            throw new IllegalArgumentException(String.valueOf(num));
        if (num > 1000)
            return 0;
        return num;
    }

    public static int GetCalledCount() {
        return callCount;
    }
}
