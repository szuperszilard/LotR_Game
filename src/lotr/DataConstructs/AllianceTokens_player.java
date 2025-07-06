package lotr.DataConstructs;

import java.util.ArrayList;

public class AllianceTokens_player {

	private ArrayList<String> tokens;

	
	public AllianceTokens_player() {
		tokens = new ArrayList<>();
	}
	
	public void addAllianceToken(String tokenName) {
		tokens.add(tokenName);
	}
	
	public ArrayList<String> getAllianceTokens(){
		return tokens;
	}
}
