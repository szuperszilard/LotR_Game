package lotr.Logic;

import lotr.DataConstructs.Player;

public class Winner {

	private static String winner = "";
	
	public static void setWinner(Player player) {
		if(player.isGood()){
			winner = "FotR";
		}else {
			winner = "Sauron";
		}
	}
	public static String getWinner() {
		return winner;
	}
}
