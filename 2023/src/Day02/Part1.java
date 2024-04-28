package Day02;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import utils.ImportUtils;

public class Part1 {

    final static Map<String, Integer> limits = Map.of("red", 12, "green", 13, "blue", 14);

    public static void main(String[] args) {

        String filePath = Path.of("asset/day-02/input.txt").toString();
        List<String> input = ImportUtils.readAsList(filePath);

        int count = 0;
        for (int i = 0; i < input.size(); i++) {
            String game = input.get(i);
            game = game.substring(game.indexOf(":") + 2);
            String[] reveals = game.split("; ");

            boolean doCount = true;
            outer:
            for (String reveal : reveals) {
                String[] cubes = reveal.split(", ");

                for (String cube : cubes) {
                    String[] pair = cube.split(" ");

                    if (limits.get(pair[1]) < Integer.parseInt(pair[0])) {
                        doCount = false;
                        break outer;
                    }
                }
            }

            if (doCount) {
                count += i + 1;
            }
        }

        System.out.println(count);
    }
}
