package lotr.UI.Logic.CardHolder;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lotr.DataConstructs.Card;
import lotr.UI.Logic.Label_Clickable_FlipShouldOccurChecker;
import lotr.UI.Logic.Label_Clickable_OverlapCheck;
import lotr.UI.inGame.Label_Clickable;
import lotr.UI.inGame.Panel_CardHolder;

public class CardHolderLogic {
	
	private static ArrayList<Label_Clickable> listOfLabels;
	private static ArrayList<Integer> listOfCardsAsIntegers;

	public static void fillCardHolders(ArrayList<Card> cards, ArrayList<Panel_CardHolder> cardHolderPanels, int chapter) throws IOException {
	
		listOfCardsAsIntegers = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
		Label_Clickable_OverlapCheck.setMapOfOverlapDependencies(Label_Clickable_OverlapCheck.readMapOfDependenciesFromFile("chapter" + chapter + "Overlap.txt"));
		Label_Clickable_FlipShouldOccurChecker.setMapOfFlipDependencies(Label_Clickable_OverlapCheck.readMapOfDependenciesFromFile("chapter" + chapter + "Flip.txt"));
		
		int[] cardCountInRowByChapter = CardCountInRowArray.getCardCountInRowArray(chapter); 
		
		FillPanelsWithCardLabels.fill(cards, cardHolderPanels, chapter, cardCountInRowByChapter);
		
	}

	public static void setListOfLabels(ArrayList<Label_Clickable> listOfLabels) {
		CardHolderLogic.listOfLabels = listOfLabels;
	}
	public static ArrayList<Label_Clickable> getListOfLabels() {
		return listOfLabels;
	}
	public static ArrayList<Integer> getListOfCardsAsIntegers() {
		return listOfCardsAsIntegers;
	}
	public static void removeFromListOfCards(int numberOfTheCardToBeRemoved) {
		listOfCardsAsIntegers.remove(Integer.valueOf(numberOfTheCardToBeRemoved));
	}
}
