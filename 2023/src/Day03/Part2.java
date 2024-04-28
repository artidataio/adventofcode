package Day03;

import utils.ImportUtils;

import java.nio.file.Path;
import java.util.*;

import static Day03.Helper.coordsCheck;

record Info(int value, int id) {
}

public class Part2 {
    public static void main(String[] args) {
        String filePath = Path.of("asset/day-03/input.txt").toString();
        char[][] input = ImportUtils.readCharTable(filePath);

        Map<Coord, Info> data = new HashMap<>();
        int id = 1;
        for (int y = 0; y < input.length; y++) {
            StringBuilder curr = new StringBuilder();
            int currStart = -1;

            for (int x = 0; x < input[0].length; x++) {
                char elem = input[y][x];

                if (Character.isDigit(elem)) {
                    curr.append(elem);

                    if (currStart == -1) {
                        currStart = x;
                    }
                }
                if (!Character.isDigit(elem) || x == input[0].length - 1) {

                    if (!curr.isEmpty()) {

                        for (int i = currStart; i <= currStart + curr.length() - 1; i++) {
                            data.put(new Coord(i, y), new Info(Integer.parseInt(String.valueOf(curr)), id));
                        }
                        id += 1;

                    }
                    curr = new StringBuilder();
                    currStart = -1;
                }
            }
        }
        int count = 0;

        for (int y = 0; y < input.length; y++) {

            for (int x = 0; x < input[0].length; x++) {
                char elem = input[y][x];

                if (elem == '*') {
                    List<Coord> coordsCheck = coordsCheck(y, x, x, input.length, input[0].length);
                    Set<Info> neighbours = new HashSet<>();

                    for (Coord coordCheck : coordsCheck) {
                        if (data.containsKey(coordCheck)) {
                            neighbours.add(data.get(coordCheck));
                        }
                    }

                    if (neighbours.size() == 2) {
                        int gearRatio = 1;
                        for (Info neighbour : neighbours) {
                            gearRatio *= neighbour.value();
                        }
                        count += gearRatio;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
