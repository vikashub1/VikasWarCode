
/**
 * SYST 17796 
 * Author: Vikas
 * Date: 18 August,2022
 */
package ca.sheridancollege.project;

/**
 *
 * @author Vikas
 */
import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> cards; 
    public Hand() {
        this.cards = new ArrayList<Card>();
    }
    public void mergeHand(Hand other) {
        for (Card c : other.cards) {
            this.addCardToBottom(c);
        }
    }
    public List<Card> take(int numCards) {
        if (numCards > this.handSize()) {
            return null;
        }

        List<Card> out = new ArrayList<>();
        for (int i = 0; i < numCards; i++) {
            out.add(this.cards.remove(this.handSize() - 1));
        }

        return out;
    }
    public void addCardToTop(Card c) {
        if (c == null) {
            throw new NullPointerException(" null card card cannot be added.");
        }
        cards.add(c);
    }
    public void addCardsToTop(List<Card> cds) {
        this.cards.addAll(cds);
    }
    public void addCardToBottom(Card c) {
        cards.add(0, c);
    }
    public Card removeCardFromTop() {
        if (handSize() < 1) {
            return null;
        }
        return cards.remove(handSize() - 1);
    }
    public Card removeCardFromBottom() {
        if (handSize() < 1) {
            return null;
        }
        return cards.remove(0);
    }
    public int handSize() {
        return cards.size();
    }

}