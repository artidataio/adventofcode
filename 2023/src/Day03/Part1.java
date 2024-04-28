package Day03;

import utils.ImportUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

record Coord(int x, int y) {
}

public class Part1 {

    private static List<Coord> coordsCheck(int y, int xStart, int xEnd, int boxWidth, int boxHeight) {
        List<Coord> out = new ArrayList<>();

        //add left top corner
        if (xStart > 0 & y > 0) {
            out.add(new Coord(xStart - 1, y - 1));
        }
        //add left bottom corner
        if (xStart > 0 & y < boxHeight - 1) {
            out.add(new Coord(xStart - 1, y + 1));
        }
        //add left side
        if (xStart > 0) {
            out.add(new Coord(xStart - 1, y));
        }

        //add right top corner
        if (xEnd < boxWidth - 1 & y > 0) {
            out.add(new Coord(xEnd + 1, y - 1));
        }
        //add right bottom corner
        if (xEnd < boxWidth - 1 & y < boxHeight - 1) {
            out.add(new Coord(xEnd + 1, y + 1));
        }
        //add right side
        if (xEnd < boxWidth - 1) {
            out.add(new Coord(xEnd + 1, y));
        }

        //add top lane
        if (y > 0) {
            for (int i = xStart; i <= xEnd; i++) {
                out.add(new Coord(i, y - 1));
            }
        }

        //add bottom lane
        if (y < boxHeight - 1) {
            for (int i = xStart; i <= xEnd; i++) {
                out.add(new Coord(i, y + 1));
            }
        }

        return out;
    }

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
