package lotr.Logic.cards;

import lotr.DataConstructs.Card;
import lotr.DataConstructs.Player;
import lotr.Logic.EffectLogic;

public class CLogic_Gray {
	
	public static void executeGray(Player player, Card card){
		if(card.getAdditionalInfo().equals("-")) {
			EffectLogic.addSkill(player, Integer.parseInt(card.getAdditionalInfo()), card.getEffectCount());
		}else if(card.getAdditionalInfo().equals("double")) {
			player.getExtraSkills()[0] = 1;
		}else if(card.getAdditionalInfo().equals("triple")) {
			player.getExtraSkills()[1] = 1;
		}
	}

}
