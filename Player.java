package week6WarGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private List<Card> hand = new ArrayList<Card>();
	private int score;
	private String name;
	//generated getters and setters
	public List<Card> getHand() {
		return hand;
	}
	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//method below is for the player to draw a card
	public void draw(Deck thisDeck) {
		Card drawnCard = thisDeck.drawCard();// the player draws card
		hand.add(drawnCard);// card goes into player's hand
	}
	
	public void incrementScore() {
		this.score ++; //here this adds the score to the player
	}
	
	public Card flip() {
		Card topOfHand = hand.get(0);
		hand.remove(0);
		return topOfHand; // here it flips the card of the player
	}
	
}
