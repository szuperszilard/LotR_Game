package lotr.Logic;

import lotr.DataConstructs.Game;
import lotr.DataConstructs.Player;

public class CheckQuest{
		
	public static void check(Game game) {
		
		Player whoseTurnItIs = GameLoop.getWhoseTurnItIs();
		int tempQotR = whoseTurnItIs.getQotR();
		if(game.getSauron().getQotR() == game.getFotR().getQotR()) {
			Winner.setWinner(whoseTurnItIs);
		}else {
			switch(tempQotR) {
				case 3,17 :{
					EffectLogic.coins(whoseTurnItIs, 1);
					break;
				}case 6,20 :{
					EffectLogic.unitPlace(Prompter.promptForRealmRed(), whoseTurnItIs, 1);
					break;
				}case 9,23 :{
					EffectLogic.takeAnotherTurn(whoseTurnItIs);
					break;
				}case 12,26 :{
					EffectLogic.takeOffTower(Prompter.promptForRealmRed());
					break;
				}case 29 :{
					Winner.setWinner(whoseTurnItIs);
					break;
				}
			}
		}		
	}
}
