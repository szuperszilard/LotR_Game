package lotr.DataConstructs;

public class Realm {

	private int unitCounter =0;	
	// negative unitCounter means Sauron units, positive means FotR units
	private int tower = 0;
	// negative tower means Sauron's tower, positive means FotR's tower
	
	public void buyRealm(Player player) {
		
		if(player.isGood()) {
			tower = 1;
		}else {
			tower = -1;
		}			
	}
	
	public void placeUnit(Player player, int howManyToPlace) {
		
		if(player.isGood()) {
			unitCounter += howManyToPlace;
		}else {
			unitCounter -= howManyToPlace;
		}
	}

	public int getUnitCounter() {
		return unitCounter;
	}

	public int getTower() {
		return tower;
	}
	
}
