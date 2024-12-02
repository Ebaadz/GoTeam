/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blackjack.goteam;

import blackjack.base.Player;
import blackjack.base.Deck;

import java.util.Scanner;

/**
 *
 * @author Ebaad
 */
public class BlackJackGoTeam {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck(); // Assuming Deck class has necessary methods for shuffling and drawing cards
        deck.shuffle();

        Player player = new Player("Player");
        Player dealer = new Player("Dealer");

        boolean playerTurn = true;

        System.out.println("Welcome to Blackjack!");

        // Player's turn
        while (playerTurn) {
            System.out.println("Your current score: " + player.getScore());
            System.out.println("Do you want to 'hit' or 'stand'?");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("hit")) {
                player.addCard(deck.dealCard());
                System.out.println("You drew a card. Your new score: " + player.getScore());

                if (player.getScore() > 21) {
                    System.out.println("You busted! Dealer wins.");
                    return;
                }
            } else if (choice.equalsIgnoreCase("stand")) {
                playerTurn = false;
            } else {
                System.out.println("Invalid input. Please type 'hit' or 'stand'.");
            }
        }

        // Dealer's turn
        while (dealer.getScore() < 21 && dealer.getScore() < player.getScore()) {
            dealer.addCard(deck.dealCard());
            System.out.println("Dealer drew a card. Dealer's score: " + dealer.getScore());
        }

        // Determine the winner
        if (dealer.getScore() > 21 || player.getScore() > dealer.getScore()) {
            System.out.println("You win! Dealer's score: " + dealer.getScore());
        } else if (dealer.getScore() == player.getScore()) {
            System.out.println("It's a tie!");
        } else {
            System.out.println("Dealer wins! Dealer's score: " + dealer.getScore());
        }
    }
}