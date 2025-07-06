package lotr.DataConstructs;

import javax.swing.ImageIcon;

public class Realm {

	private ImageIcon picture;
	private String name;
	private int[] skillCost;
	private int unitCounter;
	// negative unitCounter means Sauron units, positive means FotR units
	private int tower;
	// negative tower means Sauron's tower, positive means FotR's tower
	
	public Realm() {};
	public Realm(String name, int[] skillCost) {
		this.name = name;
		this.skillCost = skillCost;	
	}
	
	
	public String getName() {
		return name;
	}
	
	public int getUnitCounter() {
		return unitCounter;
	}

	public int getTower() {
		return tower;
	}

	public int[] getSkillCost() {
		return skillCost;
	}
	public void addUnit(int unitCounter) {
		this.unitCounter += unitCounter;
	}

	public void setTower(int tower) {
		this.tower = tower;
	}
	
}
