package Day07;

import utils.ImportUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Day07.Utils.getScoreCombo;
import static Day07.Utils.isHigherCards;

public class Part2 {

    public static void main() {
        String filePath = Path.of("asset/day-07/input.txt").toString();
        List<String> input = ImportUtils.readAsList(filePath);

        List<String> cards = new ArrayList<>();
        Map<String, Integer> bids = new HashMap<>();
        for (String elem : input) {
            String card = elem.substring(0, 5);
            int bid = Integer.parseInt(elem.substring(6).trim());
            cards.add(card);
            bids.put(card, bid);
        }

        Map<Integer, ArrayList<String>> ranks = new HashMap<>();
        for (String card : cards) {
            int scoreCombo = getScoreCombo(card,true);
            if (!ranks.containsKey(scoreCombo)) {
                ranks.put(scoreCombo, new ArrayList<>(List.of(card)));
            } else {
                ArrayList<String> orderedCards = ranks.get(scoreCombo);
                boolean isplaced = false;
                for (int i = 0; i < orderedCards.size(); i++) {
                    if (isHigherCards(orderedCards.get(i), card,true)) {
                        orderedCards.add(i, card);
                        isplaced = true;
                        break;
                    }
                }
                if (!isplaced) orderedCards.addLast(card);
            }
        }

        ArrayList<String> cardsRanked = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            if (ranks.containsKey(i)) {
                cardsRanked.addAll(ranks.get(i));
            }
        }

        int winning = 0;
        for (int i = 0; i < cardsRanked.size(); i++) {
            winning += (i + 1) * bids.get(cardsRanked.get(i));
        }
        System.out.println(winning);

    }
}
