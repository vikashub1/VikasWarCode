/**
 * SYST 17796 
 * Author: Vikas
 * Date: 18 August,2022
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Deck deck;

    private static Print printUtil = new Print();

    private Player hPlayer;
    private Player cPlayer;

    public void startGame() {
        //this prints the message in opening
        printUtil.openingMessage();
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        this.hPlayer = new Player(name);
        String cpu = input.nextLine();
        this.cPlayer = new Player(cpu);

        printUtil.startGameMessage(hPlayer);
        //a deck is created
        deck = new Deck();
        //a deck is shuffled
        deck.shuffleDeck();
        hPlayer.setHand(new Hand());
        cPlayer.setHand(new Hand());
        dealCards(hPlayer.getHand());
        dealCards(cPlayer.getHand());
        printUtil.printRoundHeader(hPlayer, cPlayer);
        int maximumRou = 27;
        Player winner = null;
        while (battle(hPlayer, cPlayer, null)) {
            maximumRou--;
            if (hPlayer.getHand().handSize() == 0) {
                winner = cPlayer;
                break;
            } else if (cPlayer.getHand().handSize() == 0) {
                winner = hPlayer;
                break;
            }
            if (maximumRou < 0) {
                break;
            }
        }

        if (winner != null) {
        } else if (hPlayer.getHand().handSize() > cPlayer.getHand().handSize()) {
            winner = hPlayer;
        } else if (cPlayer.getHand().handSize() > hPlayer.getHand().handSize()) {
            winner = cPlayer;
        } else {

            // draw
            printUtil.announceDraw();
            return;
        }
        printUtil.announceGameWinner(winner);
    }
    public void dealCards(Hand hand) {
        for (int i = 0; i < 26; i++) {
            hand.addCardToTop(deck.dealCard());
        }
    }
    public boolean battle(Player playerOne, Player playerTwo, Hand pot) {
        Card playerOneFaceUp = playerOne.getHand().removeCardFromTop();
        if (playerOneFaceUp == null) {
            return false;
        }

        Card playerTwoFaceUp = playerTwo.getHand().removeCardFromTop();
        if (playerTwoFaceUp == null) {
            return false;
        }

        if (pot == null) {
            pot = new Hand();
        }
        pot.addCardToTop(playerOneFaceUp);
        pot.addCardToTop(playerTwoFaceUp);

        int result = playerOneFaceUp.compareTo(playerTwoFaceUp);
        switch (result) {
            case 0:
                printUtil.announceWarRound();

                List<Card> warPlayerOnePot = playerOne.getHand().take(3);
                if (warPlayerOnePot == null) {
                    return false;
                }
                pot.addCardsToTop(warPlayerOnePot);

                List<Card> warPlayerTwoPot = playerTwo.getHand().take(3);
                if (warPlayerTwoPot == null) {
                    return false;
                }
                pot.addCardsToTop(warPlayerTwoPot);

                return battle(playerOne, playerTwo, pot);
            case 1:
                playerOne.getHand().mergeHand(pot);
                printUtil.announceRoundWinner(playerOne, playerOneFaceUp, playerTwo, playerTwoFaceUp, playerOne.getName());
                break;
            case -1:
                playerTwo.getHand().mergeHand(pot);
                printUtil.announceRoundWinner(playerOne, playerOneFaceUp, playerTwo, playerTwoFaceUp, playerTwo.getName());
                break;
        }

        return true;
    }
}