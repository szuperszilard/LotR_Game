package lotr.DataConstructs;

import java.util.ArrayList;

public class Discards {

	private static ArrayList<Card> discards = new ArrayList<>();
	
	public static void addCardToDiscard(Card card) {
		discards.add(card);
	};
	public static ArrayList<Card> getDiscards(){
		return discards;
	}
	public static void removeCardFromDiscard(Card card) {
		discards.remove(card);
	}
}
