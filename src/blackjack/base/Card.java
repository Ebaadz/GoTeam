/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack.base;

/**
 *
 * @author GoTeam
 */
public class Card {
    private String suit;
    private String rank;
    private int value;
    
    // creates a card with a given suit, rank, and value
    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public String getSuit() { return suit; }
    public String getRank() { return rank; }
    public int getValue() { return value; }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}