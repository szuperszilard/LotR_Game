package lotr.Logic;


import lotr.DataConstructs.Game;
import lotr.DataConstructs.Player;
import lotr.DataConstructs.RaceChips;

public class GameLoop implements ICommunication{
	
	private Game game;
	private static Player whoseTurnItIs;	
	private static int repeatCounter = 0;
	
	
	
	private GameLoop() {
		whoseTurnItIs = game.getSauron();
	};
	
	
	private void play() {
		
		while(!Winner.check(game)) {
			
			//stuff
			
			RaceChips.check(whoseTurnItIs);
			
			
			
			
			if(repeatCounter == 0) {
				whoseTurnItIs = (whoseTurnItIs.equals(game.getSauron())?game.getFotR():game.getSauron());
			}else if(repeatCounter > 0) {
				repeatCounter--;
			}	
			whoseTurnItIs.setUsedDoubleThisTurn(false);
			whoseTurnItIs.setUsedRaceSkillChipThisTurn(false);
			whoseTurnItIs.setUsedTripleThisTurn(false);
		}
	}


	public static void addRepeat() {
		repeatCounter++;
	}
	public static Player getWhoseTurnItIs() {
		return whoseTurnItIs;
	}


	@Override
	public void somethingHappened(String message) {
		if(message.equals("quest")) {
			
		}
	}
}
