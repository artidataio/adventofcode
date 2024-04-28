package Day01;

import java.nio.file.Path;
import java.util.List;

import utils.ImportUtils;

public class Part1 {

    public static void main(String[] args) {

        String filePath = Path.of("asset/day-01/input.txt").toString();
        List<String> input = ImportUtils.readAsList(filePath);

        int count = 0;

        for (String elem : input) {
            String digits = elem.replaceAll("[a-z]", "");
            count += Integer.parseInt("" + digits.charAt(0) + digits.charAt(digits.length() - 1));
        }

        System.out.println(count);

    }
}