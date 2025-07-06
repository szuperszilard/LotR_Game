package lotr.DataConstructs;

import javax.swing.ImageIcon;

public class Card {
		
	
	private ImageIcon cover;
	private int[] skillCost = new int[] {0,0,0,0,0}; 	//black, blue, red, purple, green
	private ImageIcon picture;
	private String hasChainingSymbol;
	private String usesThisChainingSymbol;
	private int coinCost;
	private String color;
	private int effectCount;
	private String additionalInfo;
	private int discardCost;
	
	// additional info meanings in regards to card color
	// purple - 0 move, 1 unit, 2 coin
	// red - realms to choose from
	// green - 0 elves, 1 dwarves, 2 hobbits, 3 men, 4 ents, 5 wizards
	// gray - 0 black, 1 blue, 2 red, 3 purple, 4 green
		
	public Card(ImageIcon cover, int[] skillCost, ImageIcon picture,  String hasChainingSymbol,
				String usesThisChainingSymbol, int coinCost, String color, int effectCount, 
				String additionalInfo, int discardCost) {
		this.cover = cover;
		this.skillCost = skillCost;
		this.picture = picture;
		this.hasChainingSymbol = hasChainingSymbol;
		this.usesThisChainingSymbol = usesThisChainingSymbol;
		this.coinCost = coinCost;
		this.color = color;
		this.effectCount = effectCount;
		this.additionalInfo = additionalInfo;
		this.discardCost = discardCost;
	}

	public int getEffectCount() {
		return effectCount;
	}

	public int getDiscardCost() {
		return discardCost;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public String getColor() {
		return color;
	}
	public int getCoinCost() {
		return coinCost;
	}
	public ImageIcon getPicture() {
		return picture;
	}
	public void setPicture(ImageIcon picture) {
		this.picture = picture;
	}
	
	public int[] getSkillCost() {
		return skillCost;
	}
	public String getHasChainingSymbol() {
		return hasChainingSymbol;
	}
	public void setHasChainingSymbol(String hasChainingSymbol) {
		this.hasChainingSymbol = hasChainingSymbol;
	}
	public String getUsesThisChainingSymbol() {
		return usesThisChainingSymbol;
	}
	public void setUsesThisChainingSymbol(String usesThisChainingSymbol) {
		this.usesThisChainingSymbol = usesThisChainingSymbol;
	}
	public void setDiscardCost(int discardCost) {
		this.discardCost = discardCost;
	}
}
