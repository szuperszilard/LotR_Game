package lotr.DataConstructs;

import javax.swing.ImageIcon;

public class Card {
	
	private ImageIcon picture;
	private int[] powerCost = new int[] {0,0,0,0,0}; 	//black, blue, red, purple, green
	private boolean chainable;
	private String hasChainingSymbol;
	private String usesThisChainingSymbol;
	private int coinCost;
	
	
	public int getCoinCost() {
		return coinCost;
	}
	public ImageIcon getPicture() {
		return picture;
	}
	public void setPicture(ImageIcon picture) {
		this.picture = picture;
	}
	
	public int[] getPowerCost() {
		return powerCost;
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
