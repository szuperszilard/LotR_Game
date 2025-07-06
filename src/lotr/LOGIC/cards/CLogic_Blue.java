package lotr.Logic.cards;

import lotr.DataConstructs.Card;
import lotr.DataConstructs.Player;
import lotr.Logic.EffectLogic;
import lotr.Logic.GameLoop;
import lotr.Logic.Prompter;

public class CLogic_Blue {

	public static void executeBlue(Player player, Card card, GameLoop gl) {
		EffectLogic.qotr(player, card.getEffectCount(), gl);
		if(player.getAllianceTokens().getAllianceTokens().contains("BluePlaceUnit")) {
			EffectLogic.unitPlace(Prompter.promptForAnyRegion(), player, 1);
		}
	}
	
}
