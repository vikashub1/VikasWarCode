
/**
 * SYST 17796 
 * Author: Vikas
 * Date: 18 August,2022
 */
package ca.sheridancollege.project;

/**
 * 
 *
 * @author Vikas
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {

    private final List<Card> cards = new ArrayList<Card>();

    Deck() {
        createDeck();
    }

    private void createDeck() {
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                cards.add(new Card(r, s));
            }
        }
    }

   //shuffles the deck of card
    public void shuffleDeck() {
        Collections.shuffle(this.cards);
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public int getCardsCount() {
        return this.cards.size();
    }

    public Card dealCard() {
        return this.cards.remove(this.cards.size() - 1);
    }
    public void addCard(Card c) {
        this.cards.add(0, c);
    }

    @Override
    public String toString() {
        return this.cards.toString();
    }
}

