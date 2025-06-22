package lotr.DataConstructs;

import java.io.IOException;
import java.util.ArrayList;




public class Game {
	
	private Player Sauron;
	private Player FotR;
	private Map map;
	private ArrayList<Card> cardsOne;
	private ArrayList<Card> cardsTwo;
	private ArrayList<Card> cardsThree;
	private ArrayList<Card> discard;
	
	public Game() throws IOException{
		
		map = new Map();
		Sauron = new Player(false);
		FotR = new Player(true);
		
		
	}

	public Player getSauron() {
		return Sauron;
	}

	public Player getFotR() {
		return FotR;
	}
	
	

}
