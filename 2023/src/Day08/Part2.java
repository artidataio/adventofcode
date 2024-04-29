package Day08;

import utils.ImportUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Part2 {
    public static void main(String[] args) {
        String filePath = Path.of("asset/day-08/input.txt").toString();
        List<String> input = ImportUtils.readAsList(filePath);

        Map<String, Pair> next = new HashMap<>();
        for (int i = 2; i < input.size(); i++) {
            String elem = input.get(i);
            next.put(elem.substring(0, 3), new Pair(elem.substring(7, 10), elem.substring(12, 15)));
        }

        List<String> currs = new ArrayList<>();
        List<Boolean> ends = new ArrayList<>();
        for (String key : next.keySet()) {
            if (key.charAt(2) == 'A') {
                currs.add(key);
                ends.add(false);
            }
        }

        String steps = input.getFirst();
        long count = 0;
        while (ends.contains(false)) {
            char step = steps.charAt((int) (count % steps.length()));
            for (int i = 0; i < currs.size(); i++) {
                String curr = currs.get(i);
                curr = step == 'L' ? next.get(curr).left() : next.get(curr).right();
                currs.set(i, curr);
                ends.set(i, curr.charAt(2) == 'Z');
            }
            System.out.println(count);

            count += 1;
        }

        System.out.println(count);
    }
}
