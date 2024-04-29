package Day04;

import utils.ImportUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part1 {
    public static void main(String[] args) {

        String filePath = Path.of("asset/day-04/input.txt").toString();
        List<String> input = ImportUtils.readAsList(filePath);

        List<Integer> countCards = new ArrayList<>(Collections.nCopies(input.size(), 1));
        for (int i = 0; i < input.size(); i++) {
            String elem = input.get(i);
            elem = elem.split(": ")[1].trim();
            int count = Utils.getCount(elem);

            int counter = 1;
            while (counter <= count) {
                countCards.set(i + counter, countCards.get(i + counter) + countCards.get(i));
                counter++;
            }
        }

        int totalCard = 0;
        for (int countCard : countCards) {
            totalCard += countCard;
        }
        System.out.println(totalCard);
    }

}
