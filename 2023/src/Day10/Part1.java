package Day10;

import utils.ImportUtils;

import java.nio.file.Path;
import java.util.*;

record Coord(int x, int y) {
}

public class Part1 {
    public static void main(String[] args) {
        String filePath = Path.of("asset/day-10/input.txt").toString();
        char[][] input = ImportUtils.readCharTable(filePath);

        Coord startCoord = null;
        Map<Coord, Map<Coord, Coord>> nextMap = new HashMap<>();
        for (int y = 0; y < input.length; y++) {
            for (int x = 0; x < input[0].length; x++) {
                char currChar = input[y][x];
                Coord curr = new Coord(x, y);
                switch (currChar) {
                    case 'S':
                        startCoord = curr;
                        break;
                    case '|':
                        nextMap.put(
                                curr,
                                Map.of(
                                        new Coord(x, y - 1), new Coord(x, y + 1),
                                        new Coord(x, y + 1), new Coord(x, y - 1)
                                )
                        );
                        break;
                    case '-':
                        nextMap.put(
                                curr,
                                Map.of(
                                        new Coord(x - 1, y), new Coord(x + 1, y),
                                        new Coord(x + 1, y), new Coord(x - 1, y)
                                )
                        );
                        break;
                    case 'L':
                        nextMap.put(
                                curr,
                                Map.of(
                                        new Coord(x, y - 1), new Coord(x + 1, y),
                                        new Coord(x + 1, y), new Coord(x, y - 1)
                                )
                        );
                        break;
                    case 'J':
                        nextMap.put(
                                curr,
                                Map.of(
                                        new Coord(x - 1, y), new Coord(x, y - 1),
                                        new Coord(x, y - 1), new Coord(x - 1, y)
                                )
                        );
                        break;
                    case '7':
                        nextMap.put(
                                curr,
                                Map.of(
                                        new Coord(x - 1, y), new Coord(x, y + 1),
                                        new Coord(x, y + 1), new Coord(x - 1, y)
                                )
                        );
                        break;
                    case 'F':
                        nextMap.put(
                                curr,
                                Map.of(
                                        new Coord(x + 1, y), new Coord(x, y + 1),
                                        new Coord(x, y + 1), new Coord(x + 1, y)
                                )
                        );
                        break;
                    default:
                        break;
                }

            }
        }

        assert startCoord != null;
        int startX = startCoord.x();
        int startY = startCoord.y();

        List<Coord> startNeighbors = new ArrayList<>(
                List.of(new Coord(startX - 1, startY),
                        new Coord(startX, startY - 1),
                        new Coord(startX + 1, startY),
                        new Coord(startX, startY + 1)));


        List<Coord> startNext = new ArrayList<>();
        for (Coord startNeighbor : startNeighbors) {
            if (nextMap.get(startNeighbor) != null &&
                    nextMap.get(startNeighbor).containsKey(startCoord)
            ) {
                startNext.add(startNeighbor);
            }
        }

        Coord curr1 = startNext.get(0);
        Coord curr2 = startNext.get(1);
        Coord prev1 = startCoord;
        Coord prev2 = startCoord;

        int count = 1;
        while (!curr2.equals(curr1)) {
            count += 1;
            Coord next1 = nextMap.get(curr1).get(prev1);
            prev1 = curr1;
            curr1 = next1;

            Coord next2 = nextMap.get(curr2).get(prev2);
            prev2 = curr2;
            curr2 = next2;
        }

        System.out.println(count);
    }
}
