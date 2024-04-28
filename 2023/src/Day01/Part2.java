package Day01;

import java.nio.file.Path;
import java.util.*;

import utils.ImportUtils;

public class Part2 {

    final static Map<Integer, String> numbers =
            Map.of(
                    0, "zero",
                    1, "one",
                    2, "two",
                    3, "three",
                    4, "four",
                    5, "five",
                    6, "six",
                    7, "seven",
                    8, "eight",
                    9, "nine"
            );

    static int indexMin(int[] array) {
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == -1) continue;
            if (array[i] < min) {
                index = i;
                min = array[i];
            }
        }
        return index;
    }

    static int indexMax(int[] array) {
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == -1) continue;
            if (array[i] > max) {
                index = i;
                max = array[i];
            }
        }
        return index;
    }
    public static String replaceLast(String text, String regex, String replacement) {
        return text.replaceFirst("(?s)"+regex+"(?!.*?"+regex+")", replacement);
    }

    public static void main(String[] args) {

        String filePath = Path.of("asset/day-01/input.txt").toString();
        List<String> input = ImportUtils.readAsList(filePath);

        int count = 0;

        for (String elem : input) {

            //Replace the first located numbers
            int[] firstIndex = new int[10];
            for (Map.Entry<Integer, String> entry : numbers.entrySet()) {
                firstIndex[entry.getKey()] = elem.indexOf(entry.getValue());
            }
            int min = indexMin(firstIndex);
            if (min != -1) {
                elem = elem.replaceFirst(numbers.get(min), String.valueOf(min));
            }

            //Replace the last located numbers
            int[] lastIndex = new int[10];
            for (Map.Entry<Integer, String> entry : numbers.entrySet()) {
                lastIndex[entry.getKey()] = elem.lastIndexOf(entry.getValue());
            }
            int max = indexMax(lastIndex);
            if (max != -1) {
                elem = replaceLast(elem,numbers.get(max), String.valueOf(max));
            }

            // Summing to count
            String digits = elem.replaceAll("[a-z]", "");
            count += Integer.parseInt("" + digits.charAt(0) + digits.charAt(digits.length() - 1));

        }

        System.out.println(count);

    }
}