package Day01;

import java.nio.file.Path;
import java.util.List;

import utils.ImportUtils;

public class Part1 {

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

        String filePath = Path.of("asset/day-01/input.txt").toString();
        List<String> input = ImportUtils.readAsList(filePath);
        int out = input
                .stream()
                .map(item -> Integer.parseInt(enforce2Digits(removeLetters(item))))
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(out);

    }
}