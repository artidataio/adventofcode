package Day07;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static Day07.Utils.*;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @ParameterizedTest(name = "handCard {0} is stronger than baseCard {1}")
    @CsvSource({"A,T", "Q,6", "9,5"})
    void isHigherCardTest(char handCard, char baseCard) {
        assertTrue(isHigherCard(handCard, baseCard));
    }

    @ParameterizedTest(name = "handCard {0} is stronger than baseCard {1}")
    @CsvSource({"A,T", "Q,6", "9,5", "2,J"})
    void isHigherCardJokerTest(char handCard, char baseCard) {
        assertTrue(isHigherCard(handCard, baseCard, true));
    }

    @ParameterizedTest(name = "handCards {0} are stronger than baseCards {1}")
    @CsvSource({"QQQJA,T55J5", "KK677,KTJJT", "33332,2AAAA", "77888,77788"})
    void areHigherCardsTest(String handCards, String baseCards) {
        assertTrue(areHigherCards(handCards, baseCards));
    }

    @ParameterizedTest(name = "handCards {0} are stronger than baseCards {1}")
    @CsvSource({"QQQJA,T55J5", "KK677,KTJJT", "33332,2AAAA", "77888,77788", "3QQQ2,JKKK2"})
    void areHigherCardsJokerTest(String handCards, String baseCards) {
        assertTrue(areHigherCards(handCards, baseCards, true));
    }

    @ParameterizedTest(name = "scoreCombo {0} has a value of {1}")
    @CsvSource({"0,23456", "1,A23A4", "2,23432", "3,TTT98", "4,23332", "5,AA8AA", "6,AAAAA"})
    void getScoreComboTest(int value, String cards) {
        assertEquals(value, getScoreCombo(cards));
    }

    @ParameterizedTest(name = "scoreCombo {1} has a value of {0}")
    @CsvSource({"0,23456", "1,A23A4", "2,23432", "3,TTT98", "4,23332", "5,AA8AA", "6,AAAAA",
            "5,T55J5", "5,QQQJA", "5,KTJJT"})
    void getScoreComboJokerTest(int value, String cards) {
        assertEquals(value, getScoreCombo(cards, true));
    }
}