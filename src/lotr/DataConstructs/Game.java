package lotr.DataConstructs;

import java.io.IOException;
import java.util.ArrayList;

import lotr.Logic.cards.CardLogic;




public class Game {
	
	private Player Sauron;
	private Player FotR;
	private Map map;
	private static ArrayList<Card> cardsOne;
	private static ArrayList<Card> cardsTwo;
	private static ArrayList<Card> cardsThree;
	private static ArrayList<Card> discard;
	
	public Game() throws IOException{
		
		map = new Map();
		Sauron = new Player(false);
		FotR = new Player(true);
		cardsOne = CardLogic.stackToUse("D:\\Eclipse\\LotRGame\\LotRpics\\Done\\cards1\\cards1.csv");
		cardsTwo =  CardLogic.stackToUse("D:\\Eclipse\\LotRGame\\LotRpics\\Done\\cards2\\cards2.csv");
		cardsThree =  CardLogic.stackToUse("D:\\Eclipse\\LotRGame\\LotRpics\\Done\\cards3\\cards3.csv");	
		discard = new ArrayList<>();
	}

	public Player getSauron() {
		return Sauron;
	}

	public Player getFotR() {
		return FotR;
	}
	
	public void addToDiscard(Card card) {
		discard.add(card);
	}
	public static void addToDiscard(ArrayList<Card> cards) {
		for(Card card : cards) {
			discard.add(card);
		}
	}

	public static ArrayList<Card> getCardsOne(){
		return cardsOne;
	}
	public static ArrayList<Card> getCardsTwo(){
		return cardsTwo;
	}
	public static ArrayList<Card> getCardsThree(){
		return cardsThree;
	}

	
}