package lotr.DataConstructs;

import java.util.ArrayList;

public class Player {

	private User user;
	private boolean good;
	// false if Sauron, true if FotR
	private int coin;
	private int[] powers = new int[] {0,0,0,0,0};
	//black, blue, red, purple, green
	private ArrayList<String> chainingSymbols;
	private boolean haveDoublePowerCard;
	private boolean haveTriplePowerCard;
	private boolean haveRacePowerChip;
	private boolean usedDoubleThisTurn;
	private boolean usedTripleThisTurn;
	private boolean usedRacePowerChipThisTurn;
	
	
	
	public boolean usedDoubleThisTurn() {
		return usedDoubleThisTurn;
	}
	public void setUsedDoubleThisTurn(boolean usedDoubleThisTurn) {
		this.usedDoubleThisTurn = usedDoubleThisTurn;
	}
	public boolean usedTripleThisTurn() {
		return usedTripleThisTurn;
	}
	public void setUsedTripleThisTurn(boolean usedTripleThisTurn) {
		this.usedTripleThisTurn = usedTripleThisTurn;
	}
	public boolean usedRacePowerChipThisTurn() {
		return usedRacePowerChipThisTurn;
	}
	public void setUsedRacePowerChipThisTurn(boolean usedRacePowerChipThisTurn) {
		this.usedRacePowerChipThisTurn = usedRacePowerChipThisTurn;
		
	}
	public boolean hasDoublePowerCard() {
		return haveDoublePowerCard;
	}
	public boolean hasTriplePowerCard() {
		return haveTriplePowerCard;
	}
	public boolean hasRacePowerChip() {
		return haveRacePowerChip;
	}


	public Player(boolean good) {
		
		if(good) {
			coin = 3;
		}else {
			coin = 2;
		}	
		chainingSymbols = new ArrayList<String>();
	}
	
		
	public boolean isGood() {
		return good;
	}
	public User getUser() {
		return user;
	}	
	public void setCoin(int coin) {
		this.coin = coin;
	}
	public int getCoin() {
		return coin;
	}	
	public int[] getPowers() {
		return powers;
	}

	public void setPowers(int[] powers) {
		this.powers = powers;
	}

	public ArrayList<String> getChainingSymbols() {
		return chainingSymbols;
	}

	public void setChainingSymbols(ArrayList<String> chainingSymbols) {
		this.chainingSymbols = chainingSymbols;
	}



}
