package lotr.Logic;

import lotr.DataConstructs.Player;
import lotr.DataConstructs.Realm;

public class RealmLogic {

	public static void buyRealm(Player player, Realm realm, GameLoop gl) throws IllegalAccessException {
		
		CheckCost.check(realm.getSkillCost(), player.getTowerCounter(), player, true);
		
		if(player.isGood()) {
			realm.setTower(1);
		}else {
			realm.setTower(-1);;
		}
		player.addTowerToCounter();		
		if(player.getAllianceTokens().contains("LandmarkTakeAnotherTurn")) {
			EffectLogic.takeAnotherTurn(player);
		}
		gl.somethingHappened("turnOver");
		
	}
	
	public static void executeRealm(Player player, Realm realm) {
		
		switch(realm.getName()) {
		
			case "Lindon" :{
				
			}
		
		}
		
	}
}
