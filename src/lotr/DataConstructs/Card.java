package lotr.DataConstructs;

import javax.swing.ImageIcon;

public class Card {
	
	private ImageIcon picture;
	private int[] skillCost = new int[] {0,0,0,0,0}; 	//black, blue, red, purple, green
	private boolean chainable;
	private String hasChainingSymbol;
	private String usesThisChainingSymbol;
	private int coinCost;
	private String color;
	private int effectType;
	private int effectCount;
	private String additionalInfo;
	private int[] purpleEffects; // 0 move, 1 -unit, 2 -coin
	
	

	public Card(ImageIcon picture, int[] skillCost, boolean chainable, String hasChainingSymbol,
				String usesThisChainingSymbol, int coinCost, String color, int effectCount, 
				int effectType, String additionalInfo, int[] purpleEffects) {
		
		this.picture = picture;
		this.skillCost = skillCost;
		this.chainable = chainable;
		this.hasChainingSymbol = hasChainingSymbol;
		this.usesThisChainingSymbol = usesThisChainingSymbol;
		this.coinCost = coinCost;
		this.color = color;
		this.effectCount = effectCount;
		this.effectType = effectType;
		this.additionalInfo = additionalInfo;
		this.purpleEffects = purpleEffects;
	}
	
	
	
	public int getEffectType() {
		return effectType;
	}



	public int getEffectCount() {
		return effectCount;
	}



	public String getAdditionalInfo() {
		return additionalInfo;
	}



	public int[] getPurpleEffects() {
		return purpleEffects;
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
	public boolean chainable() {
		return chainable;
	}
	
	

}
