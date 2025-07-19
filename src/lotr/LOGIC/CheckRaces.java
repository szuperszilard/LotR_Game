package lotr.Logic;

import lotr.DataConstructs.Player;

public class CheckRaces {
	
	public static void checkRaces(Player player) {
		
		int raceCount = 0;
		for(int i = 0; i < player.getRaces().length; i++) {
			if(player.getRaces()[i] > 0) {
				raceCount++;
			}
			if(player.getRaces()[i] == 2) {
				//SHOW TOP 2 OF RACE CHIPS AND CHOOSE
				
				player.getRaces()[i]++;
			}
		}
		if(raceCount == 3) {
			//SHOW TOP OF 3 RACES AND CHOOSE
		}	
		if((raceCount == 6) || (raceCount == 5 && player.getAllianceTokens().contains("EagleSymbol"))){
			Winner.setWinner(player);
		}
	}
	
}
