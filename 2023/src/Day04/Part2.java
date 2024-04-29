package Day04;

import utils.ImportUtils;

import java.nio.file.Path;
import java.util.List;

public class Part2 implements Utils {
    public static void main(String[] args) {
        String filePath = Path.of("asset/day-04/input.txt").toString();
        List<String> input = ImportUtils.readAsList(filePath);

        int point = 0;
        for (String elem : input) {
            elem = elem.split(": ")[1].trim();
            int count = Utils.getCount(elem);

            if (count > 0) {
                point += (int) Math.pow(2, count - 1);
            }
        }
        System.out.println(point);
    }

}
