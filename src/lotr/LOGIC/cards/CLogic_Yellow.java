package lotr.Logic.cards;

import lotr.DataConstructs.Card;
import lotr.DataConstructs.Player;
import lotr.Logic.EffectLogic;
import lotr.Logic.GameLoop;

public class CLogic_Yellow {
	
	public static void executeYellow(Player player, Card card, GameLoop gl) {
		
		EffectLogic.coins(player, card.getEffectCount());
		if(player.getAllianceTokens().getAllianceTokens().contains("YellowQotR")) {
			EffectLogic.qotr(player, 1, gl);			
		}
		if(player.getAllianceTokens().getAllianceTokens().contains("YellowTakeAnotherTrun")) {
			EffectLogic.takeAnotherTurn(player);
		}
	}
}
