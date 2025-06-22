package lotr.DataConstructs;
//black, blue, red, purple, green

public class Map {
	
	private Realm Lindon = new Realm(new int[]{0,3,0,2,1});
	private Realm Arnor = new Realm(new int[]{0,3,2,1,0});
	private Realm Rhovanion = new Realm(new int[]{1,2,1,1,1});
	private Realm Enedwaith = new Realm(new int[]{2,0,3,0,1});
	private Realm Rohan = new Realm(new int[]{3,0,0,2,1});
	private Realm Gondor = new Realm(new int[]{3,1,0,0,2});
	private Realm Mordor = new Realm(new int[]{0,0,3,2,1});
	
	public Map() {
		
		Arnor.addUnit(2);
		Mordor.addUnit(-2);
		
	}
	
	public static void placeUnit(Realm realm, Player player, int unitCount) {
		if(player.isGood()) {
			realm.addUnit(unitCount);
		}else {
			realm.addUnit(-unitCount);
		}
	}
	
	public static void moveUnit(Realm startingPlace, Realm destination, Player player, int unitCount) {
		if(player.isGood()) {
			startingPlace.addUnit(-unitCount);
			destination.addUnit(unitCount);
		}else {
			startingPlace.addUnit(unitCount);
			destination.addUnit(-unitCount);
		}		
	}

}
