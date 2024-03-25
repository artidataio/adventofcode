package Day01;

import java.nio.file.Path;
import java.util.List;

import utils.ImportUtils;

public class Part2 {

    static String replaceToNumbers(String s) {

        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int first = -1;
        int indexFirst = Integer.MAX_VALUE;
        for (int i = 0; i <= 9; i++) {
            int indexTemp = s.indexOf(numbers[i]);
            if (indexTemp >= 0 && indexTemp < indexFirst) {
                first = i;
                indexFirst = indexTemp;
            }
        }
        if (indexFirst != Integer.MAX_VALUE) {
            s = s.substring(0, indexFirst) + first
                    + s.substring(indexFirst);
            s = s.replaceFirst(numbers[first], "");
        }

        int last = -1;
        int indexLast = Integer.MIN_VALUE;
        for (int i = 0; i <= 9; i++) {
            int indexTemp = s.lastIndexOf(numbers[i]);
            if (indexTemp >= 0 && indexTemp > indexLast) {
                last = i;
                indexLast = indexTemp;
            }
        }
        if (indexLast != Integer.MIN_VALUE) {
            s = s.substring(0, indexLast) + last
                    + s.substring(indexLast);
        }

        return s;
    }

    static String removeLetters(String s) {
        return s.replaceAll("[a-z]", "");
    }

    static String enforce2Digits(String s) {
        if (s.length() > 2) {
            return String.valueOf(s.charAt(0)) +
                    s.charAt(s.length() - 1);
        }
        if (s.length() < 2) {
            return s + s;
        } else {
            return s;
        }
    }

    public static void main(String[] args) {

        String filePath = Path.of("asset/day-01/sample.txt").toString();
        List<String> input = ImportUtils.readAsList(filePath);


        int out = input
                .stream()
                .map(item -> Integer.parseInt(enforce2Digits(removeLetters(replaceToNumbers(item)))))
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(out);

    }
}