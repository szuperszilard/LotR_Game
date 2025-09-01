package lotr.UI.Logic;

import java.util.Map;

import lotr.UI.Logic.CardHolder.CardHolderLogic;

public class Label_Clickable_FlipShouldOccurChecker {
	
	private static Map<Integer, int[]> mapOfFlipDependencies;
	
	public static void checkFlip(int cardIdentifierNumber) {
		
		if(mapOfFlipDependencies.containsKey(cardIdentifierNumber)) {
			int[] cardTocheckForFlip = getMapOfFlipDependencies().get(cardIdentifierNumber);
			if(Label_Clickable_OverlapCheck.checkIfCardCanBeTaken(cardTocheckForFlip[0], CardHolderLogic.getListOfCardsAsIntegers())) {
				CardHolderLogic.getListOfLabels().get(cardTocheckForFlip[0]-1).flip();
			}
			if(cardTocheckForFlip[1]!=0) {
				if(Label_Clickable_OverlapCheck.checkIfCardCanBeTaken(cardTocheckForFlip[1], CardHolderLogic.getListOfCardsAsIntegers())) {
					CardHolderLogic.getListOfLabels().get(cardTocheckForFlip[1]-1).flip();
				}
			}			
		}		
	}
	public static Map<Integer, int[]> getMapOfFlipDependencies() {
		return mapOfFlipDependencies;
	}
	public static void setMapOfFlipDependencies(Map<Integer, int[]> mapOfFlipDependencies) {
		Label_Clickable_FlipShouldOccurChecker.mapOfFlipDependencies = mapOfFlipDependencies;
	}	
}
