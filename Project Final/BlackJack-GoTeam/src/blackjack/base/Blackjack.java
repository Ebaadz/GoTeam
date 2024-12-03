/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package blackjack.base;

import java.util.Scanner;


public class BlackjackGame {
    private Deck deck;   // Deck of cards
    private Player player; // Player's details
    private Player dealer; // Dealer's details

    // Constructor initializes the game
    public BlackjackGame() {
        this.deck = new Deck();
        this.player = new Player("Player"); // Player is named "Player"
        this.dealer = new Player("Dealer"); // Dealer is named "Dealer"
    }

    // Starts the game
    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        // Prompt to start the game
        System.out.println("Type 'start' to begin the game.");
        String input = scanner.nextLine();

        // If the user types 'start', proceed with entering the name
        if (input.equalsIgnoreCase("start")) {
            System.out.print("Enter your name: ");
            String playerName = scanner.nextLine(); // Takes input for player's name
            player.setName(playerName); // Sets the player's name

            // Deal initial cards to both the player and the dealer
            deck.shuffle();
            player.addCard(deck.dealCard());
            player.addCard(deck.dealCard());
            dealer.addCard(deck.dealCard());
            dealer.addCard(deck.dealCard());

            // Show initial hands
            System.out.println(player); // Show player's hand
            System.out.println("Dealer's hand: " + dealer.getHand().get(0) + " and [hidden card]");

            // Player's turn
            playerTurn(scanner);

            // Dealer's turn if player hasn't busted
            if (player.getScore() <= 21) {
                dealerTurn();
            }

            // Determine the winner
            determineWinner();
        } else {
            System.out.println("Game didn't start. Please type 'start' to begin.");
        }
    }

    // Handle player's turn
    private void playerTurn(Scanner scanner) {
        while (player.getScore() < 21) {
            System.out.println(player);
            System.out.print("Do you want to (h)it or (s)tand? ");
            String choice = scanner.nextLine();

            if (choice.equals("h")) {
                player.addCard(deck.dealCard());
                System.out.println(player);
            } else if (choice.equals("s")) {
                break;
            } else {
                System.out.println("Invalid input. Please choose 'h' for hit or 's' for stand.");
            }
        }
    }

    // Handle dealer's turn (dealer hits until reaching 17 or higher)
    private void dealerTurn() {
        System.out.println("Dealer's turn:");
        while (dealer.getScore() < player.getScore()) {
            dealer.addCard(deck.dealCard());
        }
        System.out.println(dealer);
    }

    // Determine the winner based on scores
    private void determineWinner() {
        if (player.getScore() > 21) {
            System.out.println(player.getName() + "Bust! You lose.");
        } else if (dealer.getScore() > 21) {
            System.out.println("Dealer busts! " + player.getName() + " wins!");
        } else if (player.getScore() > dealer.getScore()) {
            System.out.println(player.getName() + " wins with " + player.getScore() + " points.");
        } else if (player.getScore() < dealer.getScore()) {
            System.out.println("Dealer wins with " + dealer.getScore() + " points.");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame();
        game.startGame();
    }
}
