/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack.base;


import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name; // Player's or dealer's name
    private List<Card> hand; // Cards the player or dealer holds

    // Constructor
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    // Set the player's name
    public void setName(String name) {
        this.name = name;
    }

    // Get the player's name
    public String getName() {
        return name;
    }

    // Add a card to the player's hand
    public void addCard(Card card) {
        hand.add(card);
    }

    // Get the player's current score based on their hand
    public int getScore() {
        int score = 0;
        int aceCount = 0;

        // Calculate score considering Aces as either 1 or 11
        for (Card card : hand) {
            score += card.getValue();
            if (card.getRank().equals("Ace")) {
                aceCount++;
            }
        }

        // Adjust for Aces if necessary
        while (score > 21 && aceCount > 0) {
            score -= 10; // Count Ace as 1 instead of 11
            aceCount--;
        }

        return score;
    }

    // Get the hand of cards
    public List<Card> getHand() {
        return hand;
    }

    // Return the string representation of the hand
    @Override
    public String toString() {
        return name + "'s hand: " + hand + " | Score: " + getScore();
    }
}
