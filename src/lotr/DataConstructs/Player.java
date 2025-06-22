package lotr.DataConstructs;

import java.util.ArrayList;

public class Player {

	private User user;
	private boolean good;
	// false if Sauron, true if FotR
	private int coin;
	private int[] skills = new int[] {0, 0, 0, 0, 0};
	//black, blue, red, purple, green
	private ArrayList<String> chainingSymbols;
	private int towerCounter;
	private int[] raceCards = new int[] {0, 0, 0, 0, 0, 0};
	// elves, dwarves, hobbits, humans, ents, wizards
	private int questOfTheRing;
	private int[] extraSkills = new int[] {0, 0, 0}; 
	// double skill card, triple skill card, raceChip
	private boolean usedDoubleThisTurn;
	private boolean usedTripleThisTurn;
	private boolean usedRaceSkillChipThisTurn;
	
	public Player(boolean good) {
		
		if(good) {
			coin = 3;
			questOfTheRing = 14;
		}else {
			coin = 2;
			questOfTheRing = 0;
		}	
		chainingSymbols = new ArrayList<String>();
	}
	
	public int[] getRaces() {
		return raceCards;
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
	public int[] getSkills() {
		return skills;
	}

	public void addSkill(int[] skills, int colorOf) {
		this.skills = skills;
	}

	public ArrayList<String> getChainingSymbols() {
		return chainingSymbols;
	}

	public void addChainingSymbol(String symbol) {
		chainingSymbols.add(symbol);
	}
	public int getTowerCounter() {
		return towerCounter;
	}
	public void addTowerToCounter() {
		towerCounter++;
	}
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
	public boolean usedRaceSkillChipThisTurn() {
		return usedRaceSkillChipThisTurn;
	}
	public void setUsedRaceSkillChipThisTurn(boolean usedRaceSkillChipThisTurn) {
		this.usedRaceSkillChipThisTurn = usedRaceSkillChipThisTurn;
		
	}
	public int[] getExtraSkills() {
		return extraSkills;
	}
	public void addToQotR(int count) {
		questOfTheRing += count;
	}
	public int getQotR() {
		return questOfTheRing;
	}

}
