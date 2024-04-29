package Day05;

import utils.ImportUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part1 {

    public static void main(String[] args) {
        String filePath = Path.of("asset/day-05/input.txt").toString();
        List<String> input = ImportUtils.readAsList(filePath);

        List<Long> seeds = new ArrayList<>(Arrays
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

        for (int i = 0; i < seeds.size(); i++) {
            for (List<List<Long>> stage : mapping) {
                Long seed = seeds.get(i);
                for (List<Long> rule : stage) {
                    if (seed >= rule.get(1) && seed <= rule.get(1) + rule.get(2) - 1) {
                        seeds.set(i, seed - rule.get(1) + rule.get(0));
                        break;
                    }
                }
            }
        }

        long min = Long.MAX_VALUE;
        for(long seed: seeds){
            if(seed<min) min = seed;
        }

        System.out.println(min);
    }
}
