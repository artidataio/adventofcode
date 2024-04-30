package Day07;

import org.junit.jupiter.api.Test;

import static Day07.Utils.*;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void isHigherCardTest() {
        assertTrue(isHigherCard('A','T'));
        assertTrue(isHigherCard('Q','6'));
        assertTrue(isHigherCard('9','5'));
    }

    @Test
    void isHigherCardsTest() {
        assertTrue(isHigherCards("QQQJA","T55J5"));
        assertTrue(isHigherCards("KK677","KTJJT"));
        assertTrue(isHigherCards("33332","2AAAA"));
        assertTrue(isHigherCards("77888","77788"));
    }

    @Test
    void getScoreComboTest() {
        assertEquals(0,getScoreCombo("23456")); //HIGH CARD
        assertEquals(1,getScoreCombo("A23A4")); //ONE PAIR
        assertEquals(2,getScoreCombo("23432")); //TWO PAIR
        assertEquals(3,getScoreCombo("TTT98")); //THREE KIND
        assertEquals(4,getScoreCombo("23332")); //FULL HOUSE
        assertEquals(5,getScoreCombo("AA8AA")); //FOUR KIND
        assertEquals(6,getScoreCombo("AAAAA")); //FIVE KIND
    }
}