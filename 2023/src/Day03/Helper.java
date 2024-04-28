package Day03;

import java.util.ArrayList;
import java.util.List;

public interface Helper {

    static List<Coord> coordsCheck(int y, int xStart, int xEnd, int boxWidth, int boxHeight) {
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

}
