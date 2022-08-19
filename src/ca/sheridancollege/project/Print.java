
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

public class Print {

    public void openingMessage() {
        System.out.println("Please enter player1 and player 2 names.");

    }

    public void startGameMessage(Player player) {
        System.out.println("play the game");

    }
    
    public void printRoundHeader(Player playerOne, Player playerTwo) {
        String header = "#CardsInHand";
        String winner = "Round Winner";
        System.out.printf("%-20s %-20s %-20s %-20s %-20s \n", playerOne.getName(), header, playerTwo.getName(), header,
                winner);
    }
    public void announceRoundWinner(Player player1, Card card1, Player player2, Card card2, String winner) {
        System.out.printf("%-20s %-20s %-20s %-20s %s is winner.\n", card1.toString(), player1.getHand().handSize(),
                card2.toString(), player2.getHand().handSize(), winner);
    }
    public void announceWarRound() {
        System.out.println("WAR! There was a tie and War was initiated.");
    }
    public void announceGameWinner(Player player) {
        System.out.printf("The winner is %s!", player.getName());
    }

    public void announceDraw() {
        System.out.printf("Sorry, There is a draw.");
    }
}
