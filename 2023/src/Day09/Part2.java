package Day09;

import utils.ImportUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part2 {

    public static void main(String[] args) {
        String filePath = Path.of("asset/day-09/input.txt").toString();
        List<String> inputTemp = ImportUtils.readAsList(filePath);
        List<List<Integer>> input = new ArrayList<>(inputTemp.size());
        for (String elem : inputTemp) {
            input.add(new ArrayList<>(Arrays.stream(elem.split("\\s")).map(Integer::parseInt).toList()));
        }

        int count = 0;
        for (List<Integer> elem : input) {
            count += Utils.getExtraLeft(elem);
        }

        System.out.println(count);
    }
}
