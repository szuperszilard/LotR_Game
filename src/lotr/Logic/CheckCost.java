package lotr.Logic;

import lotr.DataConstructs.Player;

public class CheckCost {

	public static void check(int[] skillCost, int coinCost, Player player, boolean realm) throws IllegalAccessException {
		
		int[] temporarySkills = player.getSkills();
		int temporaryCoin = player.getCoin();
		if(realm) {
			if(player.getAllianceTokens().contains("LandmarkNoGold")) {
				coinCost = 0;
			}else {
				coinCost = player.getTowerCounter();
			}
		}
		if(temporaryCoin >= coinCost) {
			temporaryCoin -= coinCost;
			for(int i = 0; i < temporarySkills.length; i++) {
				
				if (i < 3) {
					if (temporarySkills[i] < skillCost[i]) {
						if (player.getExtraSkills()[1] == 1 && !player.usedTripleThisTurn()) {
							temporarySkills[i]++;
							player.setUsedTripleThisTurn(true);
						}
					}
					if (temporarySkills[i] < skillCost[i]) {
						if (player.getAllianceTokens().contains("AnySkillToken") && !player.usedSkillAllianceTokenThisTurn()) {
							temporarySkills[i]++;
							player.setUsedSkillAllianceTokenThisTurn(true);
						}
					}
					if (temporarySkills[i] < skillCost[i]) {
						if (temporaryCoin >= (skillCost[i] - temporarySkills[i])) {
							temporarySkills[i] += skillCost[i] - temporarySkills[i];
							temporaryCoin -= skillCost[i] - temporarySkills[i];
						} else {
							throw new IllegalAccessException("You don't have the necessary resources!");
						}
					} 
				}else {
					if (temporarySkills[i] < skillCost[i]) {
						if (player.getExtraSkills()[0] == 1 && !player.usedDoubleThisTurn()) {
							temporarySkills[i]++;
							player.setUsedDoubleThisTurn(true);
						}
					}
					if (temporarySkills[i] < skillCost[i]) {
						if (player.getAllianceTokens().contains("AnySkillToken") && !player.usedSkillAllianceTokenThisTurn()) {
							temporarySkills[i]++;
							player.setUsedSkillAllianceTokenThisTurn(true);
						}
					}
					if (temporarySkills[i] < skillCost[i]) {
						if (temporaryCoin >= (skillCost[i] - temporarySkills[i])) {
							temporarySkills[i] += skillCost[i] - temporarySkills[i];
							temporaryCoin -= skillCost[i] - temporarySkills[i];
						} else {
							throw new IllegalAccessException("You don't have the necessary resources!");
						}
					} 
				}
			}
		}else {
			throw new IllegalAccessException("You don't have the necessary resources!");
		}
		player.setCoin(temporaryCoin);
	}
}
