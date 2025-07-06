package lotr.DataConstructs;

import java.io.IOException;
import java.util.ArrayList;

import lotr.Logic.cards.CardLogic;




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
		cardsOne = CardLogic.stackToUse("D:\\Eclipse\\LotRGame\\LotRpics\\Done\\cards1\\cards1.csv");
		cardsTwo =  CardLogic.stackToUse("D:\\Eclipse\\LotRGame\\LotRpics\\Done\\cards2\\cards2.csv");
		cardsThree =  CardLogic.stackToUse("D:\\Eclipse\\LotRGame\\LotRpics\\Done\\cards3\\cards3.csv");		
	}

	public Player getSauron() {
		return Sauron;
	}

	public Player getFotR() {
		return FotR;
	}
	
	

}
