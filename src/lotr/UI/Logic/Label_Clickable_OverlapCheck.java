package lotr.UI.Logic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import lotr.UI.inGame.Label_Clickable;

public class Label_Clickable_OverlapCheck {
	
	private static Map<Integer, int[]> mapOfOverlapDependencies;
	
	public static boolean checkIfCardCanBeTaken(Label_Clickable label, ArrayList<Integer> listOfCardsAsIntegers) {
		
		boolean canBeTaken = false;
		int[] cardsToCheck = mapOfOverlapDependencies.get(label.getCardIdentifierNumber());
		if(!listOfCardsAsIntegers.contains(cardsToCheck[0]) && !listOfCardsAsIntegers.contains(cardsToCheck[1])) {
			canBeTaken = true;
		}
		return canBeTaken;
	}

	public static Map<Integer, int[]> readMapOfOverlapDependenciesFromFile(String pathToFile) {
		
		Map<Integer, int[]> mapOfOverlapDependencies = new HashMap<>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pathToFile)));
			while(br.ready()) {
				
				String[] splitLine = br.readLine().split("-");
				String[] overlapsString = splitLine[1].split(",");
				int[] overlapsIntArray = new int[] {Integer.parseInt(overlapsString[0]), Integer.parseInt(overlapsString[1])};
				mapOfOverlapDependencies.put(Integer.parseInt(splitLine[0]), overlapsIntArray);				
			}			
		} catch (IOException e) {
			System.out.println("file not found");
		}		
		return mapOfOverlapDependencies;
	}
	
	public static void setMapOfOverlapDependencies(Map<Integer, int[]> mapOfOverlapDependencies) {
		Label_Clickable_OverlapCheck.mapOfOverlapDependencies = mapOfOverlapDependencies;
	}

}
