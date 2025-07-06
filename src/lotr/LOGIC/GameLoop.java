package lotr.Logic;


import lotr.DataConstructs.Game;
import lotr.DataConstructs.Player;
import lotr.DataConstructs.AllianceTokens_player;

public class GameLoop implements ICommunication{
	
	private Game game;
	private static Player whoseTurnItIs;	
	private static int repeatCounter = 0;
	
	
	public GameLoop() {
		whoseTurnItIs = game.getSauron();
		play();
	};
	
	
	private void play() {
		
		while(Winner.getWinner().equals("")) {
			
			//stuff
			
			
			
			
			
			
			if(repeatCounter == 0) {
				whoseTurnItIs = (whoseTurnItIs.equals(game.getSauron())?game.getFotR():game.getSauron());
			}else if(repeatCounter > 0) {
				repeatCounter--;
			}	
			whoseTurnItIs.setUsedDoubleThisTurn(false);
			whoseTurnItIs.setUsedSkillAllianceTokenThisTurn(false);
			whoseTurnItIs.setUsedTripleThisTurn(false);
		}
		
		
	}


	public static void addRepeat() {
		repeatCounter++;
	}
	public static Player getWhoseTurnItIs() {
		return whoseTurnItIs;
	}

	public Game getGame() {
		return game;
	}


	@Override
	public void somethingHappened(String message) {
		
		if(message.equals("quest")) {
			CheckQuest.check(game);
		}
	}

	
}
