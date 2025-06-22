package lotr.Logic;

import lotr.DataConstructs.Card;
import lotr.DataConstructs.Player;

public class CardLogic {
	
	
	public boolean checkCost(Player player, Card card) throws IllegalAccessException {
		
		int[] temporaryPowers = player.getPowers();
		//black, blue, red, purple, green
		int temporaryCoin = player.getCoin();
		
		boolean canTake = true;
		
		if (!chainingUsed(player, card)) {
			
			for(int i = 0; i < temporaryPowers.length; i++) {
							
				if (i < 3) {
					if (temporaryPowers[i] < card.getPowerCost()[i]) {
						if (player.hasTriplePowerCard() && !player.usedTripleThisTurn()) {
							temporaryPowers[i]++;
							player.setUsedTripleThisTurn(true);
						}
					}
					if (temporaryPowers[i] < card.getPowerCost()[i]) {
						if (player.hasRacePowerChip() && !player.usedRacePowerChipThisTurn()) {
							temporaryPowers[i]++;
							player.setUsedRacePowerChipThisTurn(true);
						}
					}
					if (temporaryPowers[i] < card.getPowerCost()[i]) {
						if (temporaryCoin >= (card.getPowerCost()[i] - temporaryPowers[i])) {
							temporaryPowers[i] += card.getPowerCost()[i] - temporaryPowers[i];
							temporaryCoin -= card.getPowerCost()[i] - temporaryPowers[i];
						} else {
							throw new IllegalAccessException("You don't have the necessary resources!");
						}
					} 
				}else {
					if (temporaryPowers[i] < card.getPowerCost()[i]) {
						if (player.hasDoublePowerCard() && !player.usedDoubleThisTurn()) {
							temporaryPowers[i]++;
							player.setUsedDoubleThisTurn(true);
						}
					}
					if (temporaryPowers[i] < card.getPowerCost()[i]) {
						if (player.hasRacePowerChip() && !player.usedRacePowerChipThisTurn()) {
							temporaryPowers[i]++;
							player.setUsedRacePowerChipThisTurn(true);
						}
					}
					if (temporaryPowers[i] < card.getPowerCost()[i]) {
						if (temporaryCoin >= (card.getPowerCost()[i] - temporaryPowers[i])) {
							temporaryPowers[i] += card.getPowerCost()[i] - temporaryPowers[i];
							temporaryCoin -= card.getPowerCost()[i] - temporaryPowers[i];
						} else {
							throw new IllegalAccessException("You don't have the necessary resources!");
						}
					} 
				}
			}
			player.setCoin(temporaryCoin);			
		}	
		
		return canTake;
	}
	
	public boolean chainingUsed(Player player, Card card) {
		
		boolean chainingUsed = false;
		
		if(card.chainable()) {
			if(player.getChainingSymbols().contains(card.getUsesThisChainingSymbol())) {
				chainingUsed = true;
			}
		}
		
		return chainingUsed;
	}

}
