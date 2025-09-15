package lotr.Logic.cards;

import lotr.DataConstructs.Card;
import lotr.DataConstructs.Player;
import lotr.DataConstructs.Realm;
import lotr.Logic.EffectLogic;
import lotr.Logic.Prompter;

public class CLogic_Red {

	public static void executeRed(Player player, Card card) {
		
		int count = card.getEffectCount();
		if(player.getAllianceTokens().contains("RedOneMoreUnit")) {
			count++;
		}
		Realm realm = null;
		if(player.getAllianceTokens().contains("RedAnyRegion")) {
			realm = Prompter.promptForAnyRegion();
		}else {
			realm = Prompter.promptForRealmRed();
		}
		EffectLogic.unitPlace(realm, player, count);
	}	
}
