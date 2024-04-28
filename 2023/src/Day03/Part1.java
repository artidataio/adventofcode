package Day03;

import utils.ImportUtils;

import java.nio.file.Path;
import java.util.List;

import static Day03.Utils.coordsCheck;

public class Part1 {

    public static void main(String[] args) {
        String filePath = Path.of("asset/day-03/input.txt").toString();
        char[][] input = ImportUtils.readCharTable(filePath);

        int count = 0;

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
                        List<Coord> coordsCheck = coordsCheck(
                                y, currStart, currStart + curr.length() - 1, input.length, input[0].length);

                        for (Coord coordCheck : coordsCheck) {

                            if (input[coordCheck.y()][coordCheck.x()] != '.') {
                                count += Integer.parseInt(String.valueOf(curr));
                                break;
                            }
                        }
                    }
                    curr = new StringBuilder();
                    currStart = -1;
                }
            }
        }

        System.out.println(count);
    }
}
