package lotr.Logic.cards;

import lotr.DataConstructs.Card;
import lotr.DataConstructs.Player;
import lotr.Logic.EffectLogic;
import lotr.Logic.GameLoop;
import lotr.Logic.Prompter;

public class CLogic_Purple {

	public static void executePurple(Player player, Card card, GameLoop gl) {
		
		int[] purpleEffectsInt = new int[3];
		String[] purpleEffectsString = card.getAdditionalInfo().split(";");
		for(int i = 0; i < purpleEffectsInt.length; i++) {
			purpleEffectsInt[i] = Integer.parseInt(purpleEffectsString[i]);
		}
		if(purpleEffectsInt[0]!=0) {
			for(int j = 0; j < purpleEffectsInt[0]; j++) {
				EffectLogic.unitMove(Prompter.moveFromHere(), Prompter.moveToHere(), player);
			}
		}if(purpleEffectsInt[1]!=0) {
			for(int j = 0; j < purpleEffectsInt[1]; j++) {
				EffectLogic.unitPlace(Prompter.promptForAnyRegion(), player, -1);
			}
		}if(purpleEffectsInt[2]!=0) {
			if(player.isGood()) {
				EffectLogic.coins(gl.getGame().getSauron(), purpleEffectsInt[2]);
			}else {
				EffectLogic.coins(gl.getGame().getFotR(),purpleEffectsInt[2]);
			}				
		}		
	}	
}
