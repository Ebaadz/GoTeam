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
        score += card.getValue();
        // add a way to modulate value of Ace if score > 21
    }

    public int getScore() { return score; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return name + "'s hand: " + hand + " | Score: " + score;
    }
}