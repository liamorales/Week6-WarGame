package week6WarGame;

public class App {
	
	public static void main(String[] arg) {
		App wg = new App();
		wg.beginGame();
		
		
	}
	
	private void beginGame() {
		Deck thisDeck = new Deck();
		Player p1 = new Player();
		p1.setName("Player 1");
		Player p2 = new Player();
		p2.setName("Player 2");
		
		drawCards(thisDeck, p1, p2);
		flipCards(p1,p2);
		findWinner(p1, p2);
		
		
	}
	//Beginning the playing stage of game
	private void drawCards(Deck thisDeck, Player p1, Player p2) {
		for (int i=1; i<=26; i++) {
			p1.draw(thisDeck);
			p2.draw(thisDeck);
		} // by the end of this method, each player will have 26 cards
		
	}
	
	private void flipCards( Player p1, Player p2) {
		for (int i=1; i<=26; i++) {
			Card toHp1 = p1.flip();
			Card toHp2 = p2.flip();
			if (toHp1.getValue()>toHp2.getValue()) {
				p1.incrementScore();
			} else {
				p2.incrementScore();
			}
		} // this method ensures the players are taking turns drawing card from top and comparing 
		//value of the card and figuring out who wins
		
	}
	
	private void findWinner(Player p1, Player p2) {
		if (p1.getScore() > p2.getScore()) {
			System.out.println("Player 1 is the Winner");
		}else if (p2.getScore()>p1.getScore()){
			System.out.println("Player 2 is the Winner");
		}else {
			System.out.println("Draw");
		}
	}
	
}

