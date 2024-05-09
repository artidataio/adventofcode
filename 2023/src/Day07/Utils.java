package Day07;

import java.util.*;

public interface Utils {

    Map<Character, Integer> scoresCard = Map.ofEntries(
            Map.entry('A', 14),
            Map.entry('K', 13),
            Map.entry('Q', 12),
            Map.entry('J', 11),
            Map.entry('T', 10),
            Map.entry('9', 9),
            Map.entry('8', 8),
            Map.entry('7', 7),
            Map.entry('6', 6),
            Map.entry('5', 5),
            Map.entry('4', 4),
            Map.entry('3', 3),
            Map.entry('2', 2));

    Map<Character, Integer> scoresCardJoker = Map.ofEntries(
            Map.entry('A', 14),
            Map.entry('K', 13),
            Map.entry('Q', 12),
            Map.entry('T', 10),
            Map.entry('9', 9),
            Map.entry('8', 8),
            Map.entry('7', 7),
            Map.entry('6', 6),
            Map.entry('5', 5),
            Map.entry('4', 4),
            Map.entry('3', 3),
            Map.entry('2', 2),
            Map.entry('J', 1));

    Map<String, Integer> scoresCombo = Map.of(
            "FIVE KIND", 6,
            "FOUR KIND", 5,
            "FULL HOUSE", 4,
            "THREE KIND", 3,
            "TWO PAIR", 2,
            "ONE PAIR", 1,
            "HIGH CARD", 0
    );


    static boolean isCardStronger(char handCard, char baseCard) {
        return isCardStronger(handCard, baseCard, false);
    }

    static boolean isCardStronger(char handCard, char baseCard, boolean joker) {
        Map<Character, Integer> temp = joker ? scoresCardJoker : scoresCard;
        return temp.get(handCard) > temp.get(baseCard);
    }

    static boolean isCardEqual(char handCard, char baseCard, boolean joker) {
        Map<Character, Integer> temp = joker ? scoresCardJoker : scoresCard;
        return Objects.equals(temp.get(handCard), temp.get(baseCard));
    }


    // This method doesn't consider scoreCombo
    static boolean areCardsStronger(String handCards, String baseCards) {
        return areCardsStronger(handCards, baseCards, false);
    }

    static boolean areCardsStronger(String handCards, String baseCards, boolean joker) {
        for (int i = 0; i < handCards.length(); i++) {
            char currHand = handCards.charAt(i);
            char currBase = baseCards.charAt(i);
            if (isCardStronger(currHand, currBase, joker)) {
                return true;
            } else if (!isCardEqual(currHand, currBase, joker)) {
                return false;
            }
        }
        return false;
    }


    static int getScoreCombo(String cards) {
        return getScoreCombo(cards, false);
    }

    static int getScoreCombo(String cards, boolean joker) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            char curr = cards.charAt(i);
            countMap.put(curr, countMap.getOrDefault(curr, 0) + 1);
        }

        int countJ = 0;
        if (joker && (countMap.containsKey('J') && countMap.keySet().size() != 1)) {
            countJ = countMap.remove('J');
        }

        List<Integer> repeats = new ArrayList<>(countMap.values());
        Collections.sort(repeats);
        Collections.reverse(repeats);

        if (joker && countJ != 0) {
            repeats.set(0, repeats.getFirst() + countJ);
        }

        int out;
        if (repeats.get(0) == 1) {
            out = scoresCombo.get("HIGH CARD");
        } else if (repeats.get(0) == 2) {
            if (repeats.get(1) == 2) {
                out = scoresCombo.get("TWO PAIR");
            } else {
                out = scoresCombo.get("ONE PAIR");
            }
        } else if (repeats.get(0) == 3) {
            if (repeats.get(1) == 2) {
                out = scoresCombo.get("FULL HOUSE");
            } else {
                out = scoresCombo.get("THREE KIND");
            }
        } else if (repeats.get(0) == 4) {
            out = scoresCombo.get("FOUR KIND");
        } else {
            out = scoresCombo.get("FIVE KIND");
        }

        return out;
    }


}
