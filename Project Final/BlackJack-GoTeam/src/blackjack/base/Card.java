/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack.base;

/**
 *
 * @author Ebaad
 */


public class Card {
    private String rank; // Rank of the card (2-10, Jack, Queen, King, Ace)
    private String suit; // Suit of the card (Hearts, Spades, Diamonds, Clubs)

    // Constructor
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // Get the rank of the card
    public String getRank() {
        return rank;
    }

    // Get the suit of the card
    public String getSuit() {
        return suit;
    }

    // Get the value of the card for scoring
    public int getValue() {
        switch (rank) {
            case "Ace":
                return 11; // Ace is worth 11 points
            case "King":
            case "Queen":
            case "Jack":
                return 10; // Face cards are worth 10 points
            default:
                return Integer.parseInt(rank); // Numeric cards are worth their face value
        }
    }

    // String representation of the card
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
