package lotr.DataConstructs;
//black, blue, red, purple, green

public class Map {
	
	
	
	public Map() {
		
	}
	
	public static void placeUnit(Realm realm, Player player, int unitCount) {
		if(unitCount > 0) {
			if(player.isGood()) {
				realm.addUnit(unitCount);
			}else {
				realm.addUnit(-unitCount);
			}
		}else {
			if(player.isGood()) {
				realm.addUnit(-unitCount);
			}else {
				realm.addUnit(unitCount);
			}
		} 		
	}
	
	public static void moveUnit(Realm startingPlace, Realm destination, Player player) {
		if(player.isGood()) {
			startingPlace.addUnit(-1);
			destination.addUnit(1);
		}else {
			startingPlace.addUnit(1);
			destination.addUnit(-1);
		}		
	}

}
