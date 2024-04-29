package Day08;

import utils.ImportUtils;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part1 {
    public static void main(String[] args) {
        String filePath = Path.of("asset/day-08/input.txt").toString();
        List<String> input = ImportUtils.readAsList(filePath);

        Map<String, Pair> next = new HashMap<>();
        for (int i = 2; i < input.size(); i++) {
            String elem = input.get(i);
            next.put(elem.substring(0, 3), new Pair(elem.substring(7, 10), elem.substring(12, 15)));
        }

        String steps = input.getFirst();
        String curr = "AAA";
        int count = 0;
        while (!curr.equals("ZZZ")) {
            char step = steps.charAt(count % steps.length());
            curr = step == 'L' ? next.get(curr).left() : next.get(curr).right();
            count += 1;
        }

        System.out.println(count);
    }
}
