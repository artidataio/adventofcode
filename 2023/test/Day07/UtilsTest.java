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
        assertTrue(isHigherCard('A','T', true));
        assertTrue(isHigherCard('Q','6', true));
        assertTrue(isHigherCard('9','5',true));
        assertTrue(isHigherCard('2','J',true));
    }

    @Test
    void areHigherCardsTest() {
        assertTrue(areHigherCards("QQQJA","T55J5"));
        assertTrue(areHigherCards("KK677","KTJJT"));
        assertTrue(areHigherCards("33332","2AAAA"));
        assertTrue(areHigherCards("77888","77788"));
        assertTrue(areHigherCards("QQQJA","T55J5",true));
        assertTrue(areHigherCards("KK677","KTJJT", true));
        assertTrue(areHigherCards("33332","2AAAA",true));
        assertTrue(areHigherCards("77888","77788",true));
        assertTrue(areHigherCards("QQQQ2","JKKK2",true));
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
        assertEquals(0,getScoreCombo("23456",true)); //HIGH CARD
        assertEquals(1,getScoreCombo("A23A4",true)); //ONE PAIR
        assertEquals(2,getScoreCombo("23432",true)); //TWO PAIR
        assertEquals(3,getScoreCombo("TTT98",true)); //THREE KIND
        assertEquals(4,getScoreCombo("23332",true)); //FULL HOUSE
        assertEquals(5,getScoreCombo("AA8AA",true)); //FOUR KIND
        assertEquals(6,getScoreCombo("AAAAA",true)); //FIVE KIND
        assertEquals(5,getScoreCombo("T55J5",true)); //FOUR KIND
        assertEquals(5,getScoreCombo("QQQJA",true)); //FOUR KIND
        assertEquals(5,getScoreCombo("KTJJT",true)); //FOUR KIND
    }
}