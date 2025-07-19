package lotr.DataConstructs;


import java.util.ArrayList;

import lotr.Logic.AllianceTokenLogic;

public class AllianceTokens_ {

	private ArrayList<String> tokens;
	private static ArrayList<AllianceToken> tokens_All = AllianceTokenLogic.readTokens("D:\\Eclipse\\LotRGame\\LotRpics\\Done\\allianceTokens\\tokens.csv");
	
	public AllianceTokens_() {
		tokens = new ArrayList<>();
	}
	
	public void addAllianceTokenToPlayer(String tokenName) {
		tokens.add(tokenName);
	}
	
	public ArrayList<String> getPlayerAllianceTokens(){
		return tokens;
	}
	
	public ArrayList<AllianceToken> getAllTokenObjects(){
		return tokens_All;
	}
}
