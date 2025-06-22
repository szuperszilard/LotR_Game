package lotr.DataConstructs;

import lotr.Logic.CheckCost;

public class Realm {

	private int[] skillCost;
	private int unitCounter;
	// negative unitCounter means Sauron units, positive means FotR units
	private int tower;
	// negative tower means Sauron's tower, positive means FotR's tower
	
	public Realm(int[] skillCost) {
		this.skillCost = skillCost;	
	}
	
	public void buyRealm(Player player) throws IllegalAccessException {
		
		player.setCoin(CheckCost.check(skillCost, player.getTowerCounter(), player, true));
		if(player.isGood()) {
			tower = 1;
		}else {
			tower = -1;
		}
		player.addTowerToCounter();
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
