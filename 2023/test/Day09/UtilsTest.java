package Day09;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Day09.Utils.*;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void isRootTest() {
        List<Integer> zeroes = List.of(0, 0, 0, 0, 0);

        List<Integer> nonzeroRandoms = new ArrayList<>();
        Random ran = new Random();
        for (int i = 0; i < 5; i++) {
            int nonzero = ran.nextInt();
            while (nonzero == 0) {
                nonzero = ran.nextInt();
            }
            nonzeroRandoms.add(nonzero);
        }

        assertTrue(isRoot(zeroes));
        assertFalse(isRoot(nonzeroRandoms));
    }

    @Test
    void getAncestorsTest() {

        List<Integer> sample1 = List.of(0, 3, 6, 9, 12, 15);
        ArrayList<ArrayList<Integer>> output1 = getAncestors(sample1);
        assertEquals(List.of(List.of(3, 3, 3, 3, 3), List.of(0, 0, 0, 0)), output1);

        List<Integer> sample2 = List.of(1, 3, 6, 10, 15, 21);
        ArrayList<ArrayList<Integer>> output2 = getAncestors(sample2);
        assertEquals(List.of(List.of(2, 3, 4, 5, 6), List.of(1, 1, 1, 1), List.of(0, 0, 0)), output2);

        List<Integer> sample3 = List.of(10, 13, 16, 21, 30, 45);
        ArrayList<ArrayList<Integer>> output3 = getAncestors(sample3);
        assertEquals(List.of(List.of(3, 3, 5, 9, 15), List.of(0, 2, 4, 6), List.of(2, 2, 2), List.of(0, 0)), output3);

    }

    @Test
    void getExtraTest() {
        List<Integer> sample1 = List.of(0, 3, 6, 9, 12, 15);
        int output1 = getExtra(sample1);
        assertEquals(18, output1);

        List<Integer> sample2 = List.of(1, 3, 6, 10, 15, 21);
        int output2 = getExtra(sample2);
        assertEquals(28, output2);

        List<Integer> sample3 = List.of(10, 13, 16, 21, 30, 45);
        int output3 = getExtra(sample3);
        assertEquals(68, output3);

    }

    @Test
    void getExtraLeftTest() {
        List<Integer> sample1 = List.of(0, 3, 6, 9, 12, 15);
        int output1 = getExtraLeft(sample1);
        assertEquals(-3, output1);

        List<Integer> sample2 = List.of(1, 3, 6, 10, 15, 21);
        int output2 = getExtraLeft(sample2);
        assertEquals(0, output2);

        List<Integer> sample3 = List.of(10, 13, 16, 21, 30, 45);
        int output3 = getExtraLeft(sample3);
        assertEquals(5, output3);

    }
}