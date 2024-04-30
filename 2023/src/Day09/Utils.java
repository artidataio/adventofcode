package Day09;

import java.util.ArrayList;
import java.util.List;

public interface Utils {
    static boolean isRoot(List<Integer> integerList) {
        for (int elem : integerList) {
            if (elem != 0) {
                return false;
            }
        }
        return true;
    }

    static ArrayList<ArrayList<Integer>> getAncestors(List<Integer> integerList) {
        ArrayList<ArrayList<Integer>> out = new ArrayList<>();

        ArrayList<Integer> curr = new ArrayList<>(List.copyOf(integerList));
        while (!isRoot(curr)) {
            ArrayList<Integer> next = new ArrayList<>();
            for (int i = 0; i < curr.size() - 1; i++) {
                next.add(curr.get(i + 1) - curr.get(i));
            }
            out.add(next);
            curr = next;
        }

        return out;
    }

    static int getExtra(List<Integer> integerList) {
        ArrayList<ArrayList<Integer>> ancestors = getAncestors(integerList);
        int out = 0;
        for (ArrayList<Integer> ancestor : ancestors) {
            out += ancestor.getLast();
        }
        out += integerList.getLast();
        return out;
    }

    static int getExtraLeft(List<Integer> integerList) {
        ArrayList<ArrayList<Integer>> ancestors = getAncestors(integerList);
        int curr = 0;
        for (ArrayList<Integer> ancestor : ancestors.reversed()) {
            curr = ancestor.getFirst() - curr;
        }
        curr = integerList.getFirst() - curr;
        return curr;
    }

}
