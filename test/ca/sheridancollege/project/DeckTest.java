/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static ca.sheridancollege.project.Rank.ACE;
import static ca.sheridancollege.project.Suit.HEARTS;


public class DeckTest {

    Deck testDeck;

    @Before
    public void setUpBefore() {
        testDeck = new Deck();
    }

    @Test
    public void constructor_create52UniqueCards() {
        int expected = 52;
        int actual = new HashSet<>(testDeck.getCards()).size();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getCardsCount_returnsCountOfCardsInNewDeck() {
        int expected = 52;
        int actual = testDeck.getCardsCount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealCard_returnsLastCardInDeck() {
        Suit sExpected = Suit.HEARTS;
        Rank rExpected = Rank.ACE;
        Card actual = testDeck.dealCard();
        Suit sActual = actual.getSuit();
        Rank rActual = actual.getRank();
        Assert.assertEquals(sExpected, sActual);
        Assert.assertEquals(rExpected, rActual);
        System.out.println(testDeck.dealCard());
    }

    @Test
    public void getCardsCount_returnsCountOfCardsAfterRemoved() {
        int expected = 50;
        testDeck.dealCard();
        testDeck.dealCard();
        int actual = testDeck.getCardsCount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addCard() {


    }

}
