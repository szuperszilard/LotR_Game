package lotr.Logic.cards;

import lotr.DataConstructs.Card;
import lotr.DataConstructs.Player;
import lotr.Logic.CheckRaces;
import lotr.Logic.EffectLogic;
import lotr.Logic.Prompter;

public class CLogic_Green {

	public static void executeGreen(Player player, Card card) {
		
		EffectLogic.addRace(player, Integer.parseInt(card.getAdditionalInfo()));
		CheckRaces.checkRaces(player);
		if(player.getAllianceTokens().contains("GreenTwoMove")) {
			EffectLogic.unitMove(Prompter.moveFromHere(), Prompter.moveToHere(), player);
			EffectLogic.unitMove(Prompter.moveFromHere(), Prompter.moveToHere(), player);
		}
	}
	
}
