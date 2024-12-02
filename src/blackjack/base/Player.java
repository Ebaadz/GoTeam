/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack.base;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author GoTeam
 */
public class Player {
    private String name;
    private List<Card> hand;
    private int score;

    // creates a player with a given name
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    public void addCard(Card card) {
        hand.add(card);
        score = calcScore(); //calls method to calculate the score
    } //check score after each usage of addCard in the main method to see if game ends
    
    public int calcScore() {
        int hand_score = 0;
        int aces = 0; //track how many aces are in the hand
        for (Card c : hand) {
            hand_score += c.getValue();
            if ("A".equals(c.getRank())) {
                aces += 1;
            }
        }
        //if score exceeds 21, check if there are any aces and subtract
        //10 points for each ace
        while (aces > 0 && hand_score > 21) {
            hand_score -= 10;
            aces -= 1;
        }
        return hand_score;
    }
    public int getScore() { return score; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return name + "'s hand: " + hand + " | Score: " + score;
    }
}