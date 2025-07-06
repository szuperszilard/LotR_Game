package lotr.DataConstructs;

import java.io.IOException;
import java.util.ArrayList;

import lotr.Logic.AllianceTokenLogic;

public class AllianceTokens_global {

	private ArrayList<AllianceToken> allTokens;

	public AllianceTokens_global() throws IOException {
		
		allTokens = AllianceTokenLogic.readTokens("D:\\Eclipse\\LotRGame\\LotRpics\\Done\\allianceTokens\\tokens.csv");
	}
	
	
}
