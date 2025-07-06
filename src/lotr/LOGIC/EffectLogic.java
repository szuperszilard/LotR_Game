package lotr.Logic;

import lotr.DataConstructs.Card;
import lotr.DataConstructs.Discards;
import lotr.DataConstructs.Map;
import lotr.DataConstructs.Player;
import lotr.DataConstructs.Realm;
import lotr.Logic.cards.CardLogic;

public class EffectLogic {
	
 //effect types: 
	// 1 - coins
	// 2 - unitPlace
	// 3 - unitMove
	// 4 - takeAnotherTurn
	// 5 - takeOffTower
	// 6 - addSkill
	// 7 - addRace
	// 8 - qotr

	public static void coins(Player player, int amount) {		
		player.setCoin(player.getCoin() + amount);
	}
	
	public static void unitPlace(Realm realm, Player player, int count) {	
		if(count > 0) {
			Map.placeUnit(realm, player, count);
		}
		if(count < 0) {
			if((player.isGood() && realm.getUnitCounter() < 0) || (!player.isGood() && realm.getUnitCounter() > 0)){
				Map.placeUnit(realm, player, count);
			}
		}
	}
	
	public static void takeCardFromDiscards(Player player, GameLoop gl) {
		Card card = Prompter.promptForCardFromDiscards();
		Discards.removeCardFromDiscard(card);
		CardLogic.executeCard(player, card, gl);
	}
		
	public static void unitMove(Realm start, Realm destination, Player player) {
		Map.moveUnit(start, destination, player);
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
		// 0 elves, 1 dwarves, 2 hobbits, 3 men, 4 ents, 5 wizards
		player.getRaces()[race]++;
	}
	
	public static void qotr(Player player, int count, ICommunication comms) {
		for(int i = 0; i < count; i ++) {
			player.addToQotR(1);			
			comms.somethingHappened("quest");			
		}
	}
}
