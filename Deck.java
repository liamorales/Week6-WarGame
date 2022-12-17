package week6WarGame;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Deck{
	
	//now we are going to specify what the deck contains
	private String[] cardSuit = new String [] {"Heart", "Diamond", "Spade", "Club",};
	//because we are going to use many values that will be called at different times we will use map
	private Map<String, Integer> cardMap = new HashMap<String, Integer>();
	// here we are assigning the non numerical cards to a number, so that it has a value
	private void initCardMap() {
		//here we are going to initialize our map
		for (int i=2; i<11; i++) {
			cardMap.put(String.valueOf(i),i); //here we are initializing the map 2 - n and the rest will be with the values below
			//the map will have 14 entries to begin with
		}
		cardMap.put("Jack", 11);
		cardMap.put("Queen", 12);
		cardMap.put("King", 13);
		cardMap.put("Ace", 14);
	}
	private List <Card> cards = new ArrayList<Card>();
	// first we are creating the constructor 
	
	public List<Card> getCards(){
		return cards;
	}
	
	
	public Deck() { 
		initCardMap(); // this is here to call the map
		// now we are writing a loop that will run though each suit 4 times outer loop
		for(String suit:cardSuit) {
		//so now we are going to write a loop that we run through numbers 2-9
			cardMap.entrySet().forEach(me ->{
				String faceCard = me.getKey();
				Integer value = me.getValue();
				Card myCards =new Card();
				myCards.setName(faceCard+ "of " + suit);
				myCards.setValue(value);
				cards.add(myCards); // this is the cards list
				
			});
		//The outer loop will run for 4 suits, and the inner loop will run for 14. B/c we initialized the map to be 2-9
		// Now when we call the deck, all the cards are initialized.
		}
	}
	public void printDeck() {
		for (Card myCards:cards) {
			System.out.println(myCards.getName()+":"+ myCards.getValue());
		}
	}
	//this is the method to draw a card
	public Card drawCard() {
		Card topOfDeck = cards.get(0);// here we are drawing the top of the deck
		cards.remove(0);// after we draw a card we want it to be removed from the deck
		System.out.println("First card drawn" +" " + topOfDeck.getName());
		return topOfDeck;
	}
	
	public void shuffle() {
		ArrayList<Card> temp = new ArrayList<Card>();
		while(!cards.isEmpty()) {
			int loc=(int)(Math.random()*cards.size());
			temp.add(cards.get(loc));
			cards.remove(loc);
		}
		cards = temp;
		
	}
	
}
