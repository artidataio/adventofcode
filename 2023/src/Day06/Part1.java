package Day06;

import utils.ImportUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part1 {
    public static void main(String[] args) {
        String filePath = Path.of("asset/day-06/input.txt").toString();
        List<String> input = ImportUtils.readAsList(filePath);

        List<String> timesTemp = new ArrayList<>(Arrays.stream(input.getFirst().split("\\s+")).toList());
        timesTemp.removeFirst();
        List<Integer> times = new ArrayList<>(timesTemp.size());
        for (String elem : timesTemp) {
            times.add(Integer.parseInt(elem));
        }

        List<String> distancesTemp = new ArrayList<>(Arrays.stream(input.getLast().split("\\s+")).toList());
        distancesTemp.removeFirst();
        List<Integer> distances = new ArrayList<>(distancesTemp.size());
        for (String elem : distancesTemp) {
            distances.add(Integer.parseInt(elem));
        }

        List<Integer> ways = new ArrayList<>(times.size());
        for (int i = 0; i < times.size(); i++) {

            int time = times.get(i);
            int distance = distances.get(i);
            int count = 0;

            for (int hold = 1; hold < times.get(i); hold++) {
                int dist = hold * (time - hold);
                if (dist > distance) {
                    count++;
                }
            }

            ways.add(count);
        }

        int mult = 1;
        for (int way : ways) {
            mult *= way;
        }

        System.out.println(mult);
    }
}
