package Day05;

import utils.ImportUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part2 {

    public static void main(String[] args) {
        String filePath = Path.of("asset/day-05/input.txt").toString();
        List<String> input = ImportUtils.readAsList(filePath);

        List<Long> seedRanges = new ArrayList<>(Arrays
                .stream(input.getFirst()
                        .replace("seeds: ", "")
                        .split(" "))
                .map(Long::parseLong)
                .toList());

        List<List<List<Long>>> mapping = new ArrayList<>();
        List<List<Long>> mappingElem = new ArrayList<>();
        for (String elem : input.subList(2, input.size())) {
            if (!elem.isEmpty() && Character.isDigit(elem.charAt(0))) {
                mappingElem.add(
                        Arrays.stream(elem
                                        .split("\\s+"))
                                .map(Long::parseLong)
                                .toList());
            } else if (elem.isEmpty()) {
                mapping.add(mappingElem);
                mappingElem = new ArrayList<>();
            }
        }
        mapping.add(mappingElem); //corner case

        long min = Long.MAX_VALUE;
        for (int i = 0; i < seedRanges.size(); i += 2) {
            System.out.println(i);
            int increment = 0;
            while (increment < seedRanges.get(i + 1)) {
                long curr = seedRanges.get(i) + increment;
                for (List<List<Long>> stage : mapping) {
                    for (List<Long> rule : stage) {
                        if (curr >= rule.get(1) && curr <= rule.get(1) + rule.get(2) - 1) {
                            curr = curr - rule.get(1) + rule.get(0);
                            break;
                        }
                    }
                }
                if (curr < min) {
                    min = curr;
                }
                increment++;
            }
        }

        System.out.println(min);
    }
}
