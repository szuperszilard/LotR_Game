package lotr.Logic;

import lotr.DataConstructs.Map;
import lotr.DataConstructs.Player;
import lotr.DataConstructs.Realm;

public class EffectLogic {

	public static void coins(Player player, int amount) {		
		player.setCoin(player.getCoin() + amount);
	}
	
	public static void unitPlace(Realm realm, Player player, int count) {		
		Map.placeUnit(realm, player, count);
	}
	
	public static void unitMove(Realm start, Realm destination, Player player, int count) {
		Map.moveUnit(start, destination, player, count);
	}
	
	public static void takeAnotherTurn(Player player) {		
		GameLoop.addRepeat();
	}
	
	public static void takeOffTower(Realm realm) {
		realm.setTower(0);		
	}
	
	public static void addSkill(Player player, int skill, int count) {
		// 0 black, 1 blue, 2 red, 3 purple, 4 green
		player.getSkills()[skill] += count;
	}
	
	public static void addRace(Player player, int race) {
		// 0 elves, 1 dwarves, 2 hobbits, 3 humans, 4 ents, 5 wizards
		player.getRaces()[race]++;
	}
	
	
}
